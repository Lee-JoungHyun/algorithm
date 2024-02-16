package SAFFY.algo.s0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_이중현 {
    static int map[][], N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = -1;
            int tmp;
            for (int y = 0; y < N-M+1; y++) {
                for (int x = 0; x < N-M+1; x++) {
                    tmp = check(y, x);
                    if (answer < tmp) answer = tmp;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }

    }
    static int check(int y, int x) {
        int answer = 0;
        for (int y2 = y; y2 < y+M; y2++) {
            for (int x2 = x; x2 < x+M; x2++) {
                answer += map[y2][x2];
            }
        }
        return answer;
    }
}
