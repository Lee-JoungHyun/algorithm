package SAFFY.algo.s0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_이중현 {

    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(N, 0);
        System.out.println(answer);
    }

    static void dfs(int n, int cnt) {
        if (answer <= cnt || n < 1) return;

        if (n == 1) {
            answer = Math.min(cnt, answer);
            return;
        }

        if (n % 3 == 0) dfs(n/3, cnt+1);
        if (n % 2 == 0) dfs(n/2, cnt+1);
        dfs(n-1, cnt+1);
    }
}
