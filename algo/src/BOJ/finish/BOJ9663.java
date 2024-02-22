package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    static int N, map[], answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        nQ(0);
        System.out.println(answer);
    }
    static void nQ(int idx) {
        if (idx == N) {
            answer++;
            return;
        }
        for (int x = 0; x < N; x++) {
            if (check(idx, x)) {
                map[idx] = x;
                nQ(idx+1);
            }
        }
    }
    static boolean check(int y, int x) {
        for (int y2 = 0; y2 < y; y2++) {
            if (map[y2] == x || y-y2 == Math.abs(x-map[y2]))
                return false;
        }
        return true;
    }
}