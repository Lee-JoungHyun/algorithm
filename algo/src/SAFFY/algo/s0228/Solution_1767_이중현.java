package SAFFY.algo.s0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1767_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int[][] cores = new int[12][2];
            int coreCnt = 0;
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) {
                        cores[coreCnt][0] = y;
                        cores[coreCnt++][1] = x;
                    }
                    map[y][x] = tmp;
                }
            } // 입력과 core 세팅 끝
            int value = -1;
            for (int i = coreCnt; i > 1; i++) {
                value = find(i);
                if (value != -1) break;
            }
            sb.append("#").append(tc).append(" ").append(value).append("\n");
        }
        System.out.println(sb);
    }
    static int find(int cnt) {
        

    }
}
