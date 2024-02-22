package BOJ.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 하노이
public class BOJ11729 {
    static void go(int start, int end, int cnt) {
        for (int i = 1; i <= cnt; i++) {

            sb.append(start).append(" ").append(end);

        }
    }
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            go(3, 2, i-1);
            sb.append(1).append(" ").append(3);
            go(2, 3, i-1);
        }
    }
}
