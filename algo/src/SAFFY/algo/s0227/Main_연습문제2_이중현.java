package SAFFY.algo.s0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_연습문제2_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] * 2 + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
