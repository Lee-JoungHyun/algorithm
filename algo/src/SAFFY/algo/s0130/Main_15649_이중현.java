package SAFFY.algo.s0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_이중현 {
    public static boolean[] flagArr;
    public static int[] numbers;
    public static int N;
    public static int M;
    public static void print_perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i < N+1; i++) {
            if (flagArr[i]) continue;
            numbers[cnt] = i;
            flagArr[i] = true;
            print_perm(cnt+1);
            flagArr[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        flagArr = new boolean[N+1];
        numbers = new int[M];
        print_perm(0);

    }
}
