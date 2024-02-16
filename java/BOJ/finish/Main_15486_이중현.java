package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15486_이중현 {

    static int N, task[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        task = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            task[i][0] = Integer.parseInt(st.nextToken());
            task[i][1] = Integer.parseInt(st.nextToken());
        }
        int dp[] = new int[N+2];
        // dp는 해당 일까지 상담 종료 시 번 돈
        for (int i = 1; i <= N+1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i < N+1 && i + task[i][0] <= N+1) {
                dp[i + task[i][0]] = Math.max(dp[i + task[i][0]], dp[i] + task[i][1]);
            }
            //System.out.println(Arrays.toString(dp));
        }
        //System.out.println();
        System.out.println(dp[N+1]);
    }
}
