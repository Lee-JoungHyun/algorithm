package SAFFY.algo.s0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16926_이중현 {
    static int N, M, R, map[][], dir, tmp, tmp2;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < R; i++) {

            for (int gap = 0; gap < Math.min(M, N)/2; gap++) {
                dir = 1;
                int x = gap;
                int y = gap;
                tmp = map[y][x];
                map[y][x] = map[y][x+1];
                x+=dx[dir];
                y+=dy[dir];
                while (!(x == gap && y == gap)) {
                    if ((x==gap&&y==N-1-gap) || (y==N-1-gap&&x==M-1-gap) || (y==gap&&x==M-1-gap))
                        dir = (dir+1)%4;
                    tmp2 = map[y][x];
                    map[y][x] = tmp;
                    tmp = tmp2;
                    x+=dx[dir];
                    y+=dy[dir];
                }
            }/*
            for (int k = 0; k < N; k++)
                System.out.println(Arrays.toString(map[k]));
            System.out.println("==============================");*/
        }
        for (int y = 0; y < N; y++) {
            for(int x = 0; x < M; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }

    }
}
