package SAFFY.algo.s0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281_이중현 {
    static int answer = Integer.MIN_VALUE, N, hitters[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        hitters = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                hitters[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makePerm(0, new int[9], new boolean[9]);
        System.out.println(answer);
    }
    static void makePerm(int cnt, int[] hitter, boolean[] visited) {
        if (cnt == 9) {
            answer = Math.max(answer, check(hitter));
            return;
        }
        if (cnt == 3) {
            hitter[cnt] = 0;
            makePerm(cnt + 1, hitter, visited);
        }
        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                hitter[cnt] = i;
                makePerm(cnt + 1, hitter, visited);
                visited[i] = false;
            }
        }

    }
    static int check(int[] hitter) {
        int cnt = 0; // hitter의 위치 찾기
        int score = 0;
        for (int inning = 0; inning < N; inning++) { // 이닝 진행
            int state = 0; // 1루, 2루, 3루, 홈 상태
            int outCnt = 0;
            while (outCnt <= 2) {
                int tar = hitters[inning][hitter[cnt]];
                if (tar == 0) {
                    outCnt++;
                }
                else {
                    state = (state + 1) << tar;
                    score += Integer.bitCount(state >> 4);
                    state %= 16;
                }
                cnt = (cnt+1)%9;
            }
        }
        return score;
    }
}
