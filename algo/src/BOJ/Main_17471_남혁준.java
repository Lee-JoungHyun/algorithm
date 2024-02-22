package BOJ;

import java.io.*;
import java.util.*;

public class Main_17471_남혁준 {
    static int N, val, answer;
    static int[] people, root; // people: 구역의 인구
    static boolean[] visited, checked;
    static List<Integer>[] edges;

    static void init() {
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        }

        return root[x] = find(root[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (root[pa] < root[pb]) {
            root[pb] = pa;
        } else {
            root[pa] = pb;
        }
    }

    static void helper(int count) {
        calc();
        if (count == N / 2) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(count + 1);
                visited[i] = false;
            }
        }
    }

    static void calc() {
        Deque<Integer> dequeA = new ArrayDeque<>();
        Deque<Integer> dequeB = new ArrayDeque<>();
        int aSum = 0, bSum = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                dequeA.add(i);
            } else {
                dequeB.add(i);
            }
        }

        if (dequeA.size() == 0 || dequeB.size() == 0) { // 하나라도 팀에 포함되야 함
            return;
        }

        init();
        connection(dequeA, true);
        aSum = check(dequeA, true);

        init();
        connection(dequeB, false);
        bSum = check(dequeB, false);

        if (aSum == Integer.MAX_VALUE || bSum == Integer.MAX_VALUE) {
            return;
        }

        answer = Math.min(answer, Math.abs(aSum - bSum));
    }

    static void connection(Deque<Integer> deque, boolean team) {
        for (int cur : deque) {
            for (int val : edges[cur]) {
                if (visited[cur] == visited[val] && visited[cur] == team) {
                    union(cur, val);
                }
            }
        }
    }

    static int check(Deque<Integer> deque, boolean team) {
        int sum = 0;
        checked = new boolean[N + 1];
        int prev = find(deque.peek());

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            // 아직 방문하지 않은 곳이면서, 연결되어있는 정점이면서, 같은 팀인 경우
            if (!checked[cur] && isConnect(prev, cur) && visited[cur] == team) {
                checked[cur] = true;
                sum += people[cur];
                prev = cur;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return sum;
    }

    static boolean isConnect(int prev, int cur) {
        return find(prev) == find(cur);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        visited = new boolean[N + 1];
        checked = new boolean[N + 1];
        edges = new ArrayList[N + 1];
        root = new int[N + 1];

        answer = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) { // 인접한 구역의 번호
                val = Integer.parseInt(st.nextToken()); // 인접한 구역의 수
                edges[i].add(val);
                union(i, val);
            }
        }

        int same = 0;
        for (int i = 1; i <= N; i++) { // 두개의 선거구로 나눌 수 없는 경우 == 모두다 root[i] == i
            if (i == root[i]) {
                same++;
            }
        }

        if ((root.length != 3 && same == root.length - 1) && same == root.length - 1) { // 두개의 선거구로 나눌 수 없는 경우
            answer = -1;
        } else {
            helper(0);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }

}