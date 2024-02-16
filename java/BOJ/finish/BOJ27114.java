package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27114 {
    static BufferedReader br;
    static StringTokenizer st;
    static int K, task[] = new int[3], dp[][], go[] = new int[3];

    public static void main(String[] args) throws IOException {
        init();
        for (int E = 0; E < K+1; E++) {
            for (int dir = 0; dir < 4; dir++) {
                if (dp[E][dir] == Integer.MAX_VALUE) continue;
                for (int i = 0; i < 3; i++) {
                    if (E+task[i] <= K)
                        dp[E+task[i]][(dir+go[i])%4] = Math.min(dp[E+task[i]][(dir+go[i])%4], dp[E][dir] + 1);
                }
            }
        }
//        for (int i = 0; i < K+1; i++)
//            System.out.println(Arrays.toString(dp[i]));

        System.out.println(dp[K][0] != Integer.MAX_VALUE ? dp[K][0] : -1);
    }
    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        task[0] = Integer.parseInt(st.nextToken());
        task[1] = Integer.parseInt(st.nextToken());
        task[2] = Integer.parseInt(st.nextToken());
        go[0] = 3;
        go[1] = 1;
        go[2] = 2;
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1][4];
        dp[0][0] = 0;
        dp[0][1] = Integer.MAX_VALUE;
        dp[0][2] = Integer.MAX_VALUE;
        dp[0][3] = Integer.MAX_VALUE;
        for (int i = 1; i < K+1; i++) for (int j = 0; j < 4; j++) dp[i][j] = Integer.MAX_VALUE;

    }
}
