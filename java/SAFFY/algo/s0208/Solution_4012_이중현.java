package SAFFY.algo.s0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_이중현 {
    static int N, map[][], answer;//, foods[];
    static boolean foods[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            //foods = new int[N/2];
            foods = new boolean[N];
            answer = Integer.MAX_VALUE;
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }// 입력 끝
            makeCombi(0, 0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void makeCombi(int cnt, int start) {
        if (cnt == N/2) {
            check();
            return;
        }
        for (int i = start; i < N; i++) {
            foods[i] = true;
            makeCombi(cnt+1, i+1);
            foods[i] = false;
        }

    }
    static void check() {
        // 1. 선택된 값 계산
        int select = 0;
        for (int i = 0; i < N-1; i++) {
            if (!foods[i]) continue;
            for (int j = i+1; j < N; j++) {
                if (!foods[j]) continue;
                select += map[i][j] + map[j][i];
            }
        }
        int unselect = 0;
        for (int i = 0; i < N-1; i++) {
            if (foods[i]) continue;
            for (int j = i+1; j < N; j++) {
                if (foods[j]) continue;
                unselect += map[i][j] + map[j][i];
            }
        }
        //System.out.println(select + ", " + unselect);
        answer = Math.min(answer, Math.abs(select - unselect));

    }
}
