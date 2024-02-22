package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1013 {
    static String arr;
    static boolean flag1, flag2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            arr = br.readLine();
            if (arr.matches("(100+1+|01)+"))
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
