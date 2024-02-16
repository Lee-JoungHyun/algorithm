package SAFFY.algo.s0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_이중현 {
    static int N, top;
    static Stack<int[]> dp; // 나보다 왼쪽이면서 나보다 큰놈들
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder(0 + " ");
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Stack<>();
        st = new StringTokenizer(br.readLine());
        dp.push(new int[]{Integer.parseInt(st.nextToken()), 0});
        for (int i = 1; i < N; i++) {
            top = Integer.parseInt(st.nextToken());
            while (!dp.isEmpty() && dp.peek()[0] <= top) dp.pop();
            if (dp.isEmpty()) {
                sb.append(0).append(" ");
                dp.push(new int[]{top, i});
            } else {
                sb.append((dp.peek()[1] + 1) + " ");
                dp.push(new int[]{top, i});
            }
        }
        System.out.println(sb);
    }
}


