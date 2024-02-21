package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238 {
    static int N, M, X, xToH[], hToX[];//
    static LinkedList<int[]>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        edges = new LinkedList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[Integer.parseInt(st.nextToken())].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        } // 입력 끝
        // X -> 집 거리 계산
        //System.out.println("X -> 집들");
        xToH = new int[N+1];
        hToX = new int[N+1];
        Arrays.fill(xToH, Integer.MAX_VALUE);
        Arrays.fill(hToX, Integer.MAX_VALUE);
        dij(X, -1, xToH);//, Integer.MAX_VALUE);

        // 집 -> X 계산
        int[] tmp = new int[N+1];
        for (int home = 1; home <= N; home++) {
            //System.out.println("집" + home + " -> X");
            Arrays.fill(tmp, Integer.MAX_VALUE);
            dij(home, X, tmp);
        }
        //System.out.println(Arrays.toString(hToX));
        //System.out.println(Arrays.toString(xToH));

        int min = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            min = Math.max(min, hToX[i] + xToH[i]);
        }

        System.out.println(min);
    }
    // 시작점, 찾으면 종료(없으면-1), 거리 초기화할 배열, 종료할 길이
    static void dij(int start, int target, int[] distance) { //, int stopDistance) {
        if (start == target) return;
        boolean[] visited = new boolean[N + 1];
        distance[start] = 0;
        visited[start] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        for (int[] edge : edges[start]) {
            distance[edge[0]] = Math.min(edge[1], distance[edge[0]]);
            pq.add(edge);
        } // 시작점 넣고 초기화 하는 초기작업 완료
        //System.out.println(Arrays.toString(distance));
        int[] now;
        while (!pq.isEmpty()) {
            now = pq.poll();
            //System.out.println("노드: " + Arrays.toString(now));
            // 타겟 확인 종료조건 (집 -> X 만 적용)
            if (now[0] == target) {
                hToX[start] = now[1];
                return;
            }
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            // 첫 방문!
            distance[now[0]] = now[1];
            for (int[] edge : edges[now[0]]) {
                //if (edge[1] + now[1] + xToH[start] < stopDistance) {
                if (distance[edge[0]] > now[1] + edge[1])
                    pq.add(new int[]{edge[0], now[1] + edge[1]});
            }
            //System.out.println(Arrays.toString(distance));
        }



    }
}
