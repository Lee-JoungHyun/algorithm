package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753_7 {
    static int V, E, start, now[];
    static ArrayList<int[]>[] edges;
    static PriorityQueue<int[]> pq;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int[] answer = new int[V+1];
        int noCnt = V-1; // (start 방문)
        visited = new boolean[V + 1];
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.fill(answer, Integer.MAX_VALUE);
        start = Integer.parseInt(br.readLine());
        visited[start] = true;
        answer[start] = 0;
        edges = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[Integer.parseInt(st.nextToken())].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        for (int[] edge : edges[start]) {
            answer[edge[0]] = Math.min(answer[edge[0]], answer[start] + edge[1]);
            pq.add(edge);
        }
        // 입력, 세팅 끝
        while (noCnt > 0 && !pq.isEmpty()) {
            now = pq.poll();
            if (!visited[now[0]]) {
                visited[now[0]] = true;
                noCnt--;
                for (int[] edge : edges[now[0]]) {
                    answer[edge[0]] = Math.min(answer[edge[0]], answer[now[0]] + edge[1]);
                    pq.add(new int[]{edge[0], answer[edge[0]]});
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]).append("\n");
        }
        System.out.print(sb);

    }

}
