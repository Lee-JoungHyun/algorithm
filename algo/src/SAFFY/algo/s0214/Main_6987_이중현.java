package SAFFY.algo.s0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6987_이중현 {
    static boolean flag[];
    // flag가 true면 불가능한 결과!
    static int table[][], w, d, l, drawSum[], winSum[], loseSum[];
    public static void main(String[] args) throws IOException {
        table = new int[6][12];
        flag = new boolean[4];
        drawSum = new int[4];
        winSum = new int[4];
        loseSum = new int[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 0; tc < 4; tc++) { // tc는 게임별임
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 6; c++) { // c는 나라임
                w = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                winSum[tc] += w;
                drawSum[tc] += d;
                loseSum[tc] += l;
                if (flag[tc]) continue;
                // 1. 나라당 sum = 5인지 확인
                if (w + d + l != 5) flag[tc] = true;
                else {
                    table[c][(tc*3)] = w;
                    table[c][(tc*3)+1] = d;
                    table[c][(tc*3)+2] = l;
                }
            }
        }

        for (int tc = 0; tc < 4; tc++) {
            // 2. case 별 sum(win) == sum(lose) 확인, 3. 무승부 sum이 짝수
            if (flag[tc]) continue;
            if (winSum[tc] != loseSum[tc] || drawSum[tc]%2 == 1) {
                flag[tc] = true;
                continue;
            }
            for (int i = 0; i < 6; i++) {
                // 4. 본인 승수 <= 전체 패배 - 본인 패배
                // 5. 본인 무승부 =< 본인 제외 무승부 sum
                // 6. 본인 패배 <= 전체 승수 - 본인 승수
                if (loseSum[tc] - table[i][tc*3+2] < table[i][tc*3] || drawSum[tc] - table[i][tc*3+1] < table[i][tc*3+1] || winSum[tc] - table[i][tc*3] < table[i][tc*3+2]) {
                    flag[tc] = true;
                    break;
                }
            }
        }


        for (int i = 0; i < 4; i++)
            System.out.printf((flag[i] ? 0 : 1) + " ");



    }
}
