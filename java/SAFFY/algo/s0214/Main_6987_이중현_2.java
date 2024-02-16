package SAFFY.algo.s0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6987_이중현_2 {

    static int countrys[][], sample[][], games[][], w, d, l;
    static boolean answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        countrys = new int[6][3];
        games = new int[15][2];
        answer = new boolean[4];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 6; j++) {
                games[idx][0] = i;
                games[idx++][1] = j;

            }
        }
//        for (int i = 0; i < 15; i++)
//            System.out.println(Arrays.toString(games[i]));

        for (int tc = 0; tc < 4; tc++) {
            boolean flag = true;
            sample = new int[6][3];
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 6; c++) {
                w = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                countrys[c][0] = w;
                countrys[c][1] = d;
                countrys[c][2] = l;
                if (w + d + l != 5) flag = false;
            }// 입력 끝
            if (flag)
                setGames(0, tc);
        }
        for (int i = 0; i < 4; i++) {
            if (answer[i])
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }
    static void setGames(int gIdx, int tc) {
        //System.out.println(gIdx);
        if (gIdx == 15) {
            answer[tc] = true;
            return;
        }
        // 0이 길때 (승수, 패배수 바꾸기)
        if (countrys[games[gIdx][0]][0] > sample[games[gIdx][0]][0] && countrys[games[gIdx][1]][2] > sample[games[gIdx][1]][2]) {
            sample[games[gIdx][0]][0]++;
            sample[games[gIdx][1]][2]++;
            setGames(gIdx+1, tc);
            sample[games[gIdx][0]][0]--;
            sample[games[gIdx][1]][2]--;
        }
        // 무승부일때
        if (countrys[games[gIdx][0]][1] > sample[games[gIdx][0]][1] && countrys[games[gIdx][1]][1] > sample[games[gIdx][1]][1]) {
            sample[games[gIdx][0]][1]++;
            sample[games[gIdx][1]][1]++;
            setGames(gIdx+1, tc);
            sample[games[gIdx][0]][1]--;
            sample[games[gIdx][1]][1]--;
        }
        // 0이 질때
        if (countrys[games[gIdx][0]][2] > sample[games[gIdx][0]][2] && countrys[games[gIdx][1]][0] > sample[games[gIdx][1]][0]) {
            sample[games[gIdx][0]][2]++;
            sample[games[gIdx][1]][0]++;
            setGames(gIdx+1, tc);
            sample[games[gIdx][0]][2]--;
            sample[games[gIdx][1]][0]--;
        }
    }

}
