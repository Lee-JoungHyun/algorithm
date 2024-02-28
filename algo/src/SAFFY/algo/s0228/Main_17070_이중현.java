package SAFFY.algo.s0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_이중현 {

    static int dx[] = new int[]{1, 1, 0};
    static int dy[] = new int[]{0, 1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = calc(0, N - 1, N - 1) + calc(1, N - 1, N - 1) + calc(2, N - 1, N - 1);
        System.out.println(answer);
    }
    static int calc(int state, int y, int x) {
        if (y < 0 || x < 1) return 0;




        if (state == 0) {
            return calc(0, y, x - 1) + calc(1, y - 1, x - 1);
        }
        else if (state == 1) {
            return calc(0, y, x - 1) + calc(1, y - 1, x - 1) + calc(2, y - 1, x);
        }
        else {
            return calc(1, y - 1, x - 1) + calc(2, y - 1, x);
        }
    }
}
