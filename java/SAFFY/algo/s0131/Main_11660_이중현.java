package SAFFY.algo.s0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11660_이중현 {
    public static void main(String[] args) throws IOException {
        // x,y의 구간합은 map[y][x] + sum[y-1][x] + sum[y][x-1] - sum[y-1][x-1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] sum = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (x == 0 && y == 0)
                    sum[y][x] = map[y][x];
                else if(0 < y && 0 < x)
                    sum[y][x] = map[y][x] + sum[y-1][x] + sum[y][x-1] - sum[y-1][x-1];
                else if (0 == x)
                    sum[y][x] = sum[y-1][x] + map[y][x];
                else
                    sum[y][x] = sum[y][x-1] + map[y][x];
            }
        }
        int preX, preY, postX, postY, answer;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            preY = Integer.parseInt(st.nextToken())-1;
            preX = Integer.parseInt(st.nextToken())-1;
            postY = Integer.parseInt(st.nextToken())-1;
            postX = Integer.parseInt(st.nextToken())-1;
            answer = sum[postY][postX];
            if (preX == 0 && preY == 0)
                System.out.println(answer);
            else if (preX == 0)
                System.out.println(answer - sum[preY-1][postX]);
            else if (preY == 0)
                System.out.println(answer - sum[postY][preX-1]);
            else
                System.out.println(answer - sum[preY-1][postX] - sum[postY][preX-1] + sum[preY-1][preX-1]);
        }
    }
}
