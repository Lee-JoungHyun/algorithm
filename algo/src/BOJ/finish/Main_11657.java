package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_11657 {
    static int N, M;
    static long distance[];
    static LinkedList<int[]>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        edges = new LinkedList[N+1];
        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
            edges[i] = new LinkedList<>();
        }
        distance[1] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[Integer.parseInt(st.nextToken())].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        // 입력, 세팅 완료
        StringBuilder sb = new StringBuilder();
        if (bellman()) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] != Integer.MAX_VALUE)
                    sb.append(distance[i]).append("\n");
                else
                    sb.append(-1).append("\n");
            }
        }else{
            sb.append(-1);
        }
        System.out.println(sb);

    }
    static boolean bellman() {
        for (int n = 1; n < N; n++) {
            for (int node = 1; node <= N; node++) {
                if (distance[node] == Integer.MAX_VALUE) continue;
                for (int [] edge : edges[node]) {
                    distance[edge[0]] = Math.min(distance[edge[0]], distance[node] + edge[1]);
                }
            }
        }
        for (int node = 1; node <= N; node++) {
            if (distance[node] == Integer.MAX_VALUE) continue;
            for (int [] edge : edges[node]) {
                if (distance[edge[0]] > distance[node] + edge[1])
                    return false;
            }
        }
        return true;
    }
}
