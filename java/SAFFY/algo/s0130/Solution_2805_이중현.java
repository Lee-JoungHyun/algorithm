package SAFFY.algo.s0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        int gap;
        int answer;
        boolean flag;
        for(int tc = 1; tc < T+1; tc++) {
            flag = true;
            N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][];
            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
            gap = N/2;
            answer = map[0][gap]-'0';
            for(int y = 1; y < N; y++) {
                if (flag) gap--;
                else gap++;

                for (int x = gap; x < N-gap; x++) answer+=map[y][x]-'0';

                if (gap == 0) flag = false;
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
