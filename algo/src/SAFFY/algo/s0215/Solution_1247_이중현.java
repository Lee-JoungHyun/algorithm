package SAFFY.algo.s0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_이중현 {
    static int N, comp[] = new int[2], home[] = new int[2], customer[][], answer;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            customer = new int[N][2];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            comp[0] = Integer.parseInt(st.nextToken());
            comp[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());
            }


            for (int i = 0; i < N; i++) {
                System.out.println("start: " + i);
                visited[i] = true;
                DFS(customer[i], 0, calcDis(customer[i], comp));
                visited[i] = false;
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void DFS(int[] now, int cnt, int cost) {
        if (cnt == N-1) {
            answer = Math.min(cost + calcDis(now, home), answer);
            //System.out.println(answer);
            return;
        }
        for (int i = 0; i < N; i++) {
            // 방문한적 있음 or 해당 경로 cost > 미리 간 경로 answer
            if(visited[i] || calcDis(now, customer[i]) > answer) continue;
            visited[i] = true;
            //System.out.println(i);
            DFS(customer[i], cnt+1, cost+ calcDis(now, customer[i]));
            visited[i] = false;
        }
    }
    static int calcDis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
