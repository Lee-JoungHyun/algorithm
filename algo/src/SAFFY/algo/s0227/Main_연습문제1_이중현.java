package SAFFY.algo.s0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_연습문제1_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[N-1][0] + dp[N-1][1]);

    }
}
