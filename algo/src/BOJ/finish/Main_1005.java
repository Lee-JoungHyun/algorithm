package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1005 {
    static int N, K, spends[], W, answer[], inputCnt[], dp[];
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            spends = new int[N+1];
            inputCnt = new int[N+1];
            dp = new int[N+1];
            graph = new ArrayList[N + 1];
            answer = new int[N+1];
            for (int i = 1; i <= N; i++) {
                spends[i] = Integer.parseInt(st.nextToken());
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int post = Integer.parseInt(st.nextToken());
                graph[pre].add(post);
                inputCnt[post]++;
            }
            W = Integer.parseInt(br.readLine());
            // 1. 진입 차수? 0인거 찾아 queue에 넣고 dp 갱신해주기
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inputCnt[i] == 0) queue.add(i);
                dp[i] = spends[i];
            }
            //System.out.println("진입차수들: " + Arrays.toString(inputCnt));
            // 2. 위상정렬 하면서 dp초기화 해주기
            int end;
            while (!queue.isEmpty()) {
                end = queue.poll(); // 끝난놈 처리
                //System.out.println("끝난놈: " + end);
                for (int nxt : graph[end]) {
                    dp[nxt] = Math.max(dp[nxt], dp[end]+spends[nxt]);
                    if (--inputCnt[nxt] == 0) { // 진입차수 끝이면
                        //System.out.println("진입차수0 : " + nxt);
                        // nxt = 진입차수가 0이 된 녀석, pre는 nxt의 전 녀석들
                        queue.add(nxt);
                        if (nxt == W) {
                            queue.clear();
                            break;
                        }
                    }
                }
            }
            //System.out.println("진입차수들: " + Arrays.toString(inputCnt));
            //sb.append(dp[W] + ": " + Arrays.toString(dp)).append("\n");
            sb.append(dp[W]).append("\n");
        }
        System.out.println(sb);
    }

}
