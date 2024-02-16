package SAFFY.algo.s0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_이중현 {
    static long answer = Long.MAX_VALUE;
    static long[][] foods;
    static void calc(int n) {
        long t0; // 신맛 (전체 곱)
        long t1; // 쓴맛 (전체 합)
        for (int i = 1, caseCont = 1<<n; i < caseCont; i++) {
            t0 = 1;
            t1 = 0;
            for (int j = 0; j < n; j++) {
                if ((i&1<<j) != 0) {
                    t0 *= foods[j][0];
                    t1 += foods[j][1];
                }
            }
            if (answer > Math.abs(t0-t1)) answer = Math.abs(t0-t1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        foods = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i][0] = Long.parseLong(st.nextToken());
            foods[i][1] = Long.parseLong(st.nextToken());
        }
        calc(N);
        System.out.println(answer);


    }
}
