package SAFFY.algo.s0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_이중현 {

    static long[][] pascal = new long[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        pascal[0][0] = 1;
        pascal[1][0] = 1;
        pascal[1][1] = 1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(facto(c, r)).append("\n");
        }
        System.out.println(sb);
    }
    public static long facto(int c, int r) {
        //System.out.println("facto: " + c + ", " + r);
        if (pascal[c][r] != 0) return pascal[c][r];
        if (r == 0 || r == c) return 1;
        return pascal[c][r] = facto(c - 1, r - 1) + facto(c - 1, r);
    }
}
