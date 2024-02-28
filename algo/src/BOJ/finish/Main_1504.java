package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504 {

    static int N, E, u, v;
    static ArrayList<int[]>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        // 1. u <-> v 거리 구하기
        int uv = dij(u, v);

        // 2. 1 -> u - v -> N
        int oToU = dij(1, u);
        int vToN = dij(v, N);
        int t1;
        if (oToU == -1 || vToN == -1)
            t1 = -1;
        else
            t1 = oToU + vToN + uv;

        // 3. 1 -> v - u -> N
        int oToV = dij(1, v);
        int uToN = dij(u, N);
        int t2;
        if (oToV == -1 || uToN == -1)
            t2 = -1;
        else
            t2 = oToV + uToN + uv;

        // 출력
        if (uv == -1)
            System.out.println(-1);
        else if (t1 == t2 && t2 == -1)
            System.out.println(-1);
        else if (t1 == -1)
            System.out.println(t2);
        else if (t2 == -1)
            System.out.println(t1);
        else
            System.out.println(Math.min(t1, t2));
    }
    static int dij(int start, int target) {
        if (start == target) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        boolean visited[] = new boolean[N + 1];
        visited[start] = true;
        for (int[] edge : edges[start]) {
            pq.add(new int[] {edge[0], edge[1]});
        }
        int[] now;
        while (!pq.isEmpty()) {
            now = pq.poll();
            if (now[0] == target) return now[1];
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                for (int[] nxt : edges[now[0]]) {
                    pq.add(new int[]{nxt[0], nxt[1] + now[1]});
                }
            }
        }


        return -1;
    }
}
