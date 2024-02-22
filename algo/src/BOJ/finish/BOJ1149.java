package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int N, houses[][], dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        houses = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        } // 입력 끝
        //dp[거리][집] 의 값은 나와 다른 색의 최솟값의 합
        dp[0][0] = houses[0][0];
        dp[0][1] = houses[0][1];
        dp[0][2] = houses[0][2];
        for (int i = 1; i < N; i++) {
            for (int now = 0; now < 3; now++) {
                dp[i][now] = Math.min(Math.min(
                        (now == 0 ? Integer.MAX_VALUE : (dp[i-1][0] + houses[i][now])),
                        (now == 1 ? Integer.MAX_VALUE : (dp[i-1][1] + houses[i][now]))),
                        (now == 2 ? Integer.MAX_VALUE : (dp[i-1][2] + houses[i][now])));
            }
        }
//        for (int i = 0; i < N; i++)
//            System.out.println(Arrays.toString(dp[i]));
        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}
