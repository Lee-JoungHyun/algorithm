package SAFFY.algo.s0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_이중현 {
    static int N, L, foods[][], answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            foods = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                foods[i][0] = Integer.parseInt(st.nextToken());
                foods[i][1] = Integer.parseInt(st.nextToken());
            }
            //System.out.println("시작");
            makeBurger(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void makeBurger(int tast, int calo, int start) {
        //System.out.println("start: " + start + " tast: " + c);
        if (calo >= L) return;
        //System.out.println(tast + ", " + calo);
        answer = Math.max(answer, tast);
        for(int i = start; i < N; i++) {
            int nxtT = tast + foods[i][0];
            int nxtC = calo + foods[i][1];
            //System.out.println("다음은: " + nxtT + ", " + nxtC);
            makeBurger(nxtT, nxtC, i+1);
        }
    }
}
