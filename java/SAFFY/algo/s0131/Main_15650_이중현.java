package SAFFY.algo.s0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_이중현 {
    static int N;
    static int M;
    static int[] answer;
    public static void combi(int cnt, int start) {
        if (cnt == M) {
            for (int e : answer)
                System.out.print(e + " ");
            System.out.println();
            return;
        }
        for(int i = start; i < N+1; i++) {
            answer[cnt] = i;
            combi(cnt+1, i+1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        combi(0, 1);

    }
}
