package SAFFY.algo.s0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_이중현 {
    static int N, M, R, map[][], tmp[][];
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            doing(Integer.parseInt(st.nextToken()));
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                System.out.printf(map[y][x] + " ");
            }
            System.out.println();
        }
    }
    static void doing(int n) {
        if (n == 1) t1();
        else if (n == 2) t2();
        else if (n == 3) t3();
        else if (n == 4) t4();
        else if (n == 5) t5();
        else t6();
    }
    static void t1() { // 상하
        int tmp = 0;
        for (int y = 0; y < (N/2); y++) {
            for (int x = 0; x < M; x++) {
                tmp = map[y][x];
                map[y][x] = map[N-1-y][x];
                map[N-1-y][x] = tmp;
            }
        }
    }
    static void t2() {
        int tmp = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M/2; x++) {
                tmp = map[y][x];
                map[y][x] = map[y][M-1-x];
                map[y][M-1-x] = tmp;
            }
        }
    }
    static void t3() {
        tmp = new int[M][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tmp[x][N-1-y] = map[y][x];
            }
        }
        map = tmp;
        int temp = N;
        N = M;
        M = temp;
    }
    static void t4() {
        tmp = new int[M][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                tmp[M-x-1][y] = map[y][x];
            }
        }
        map = tmp;
        int temp = N;
        N = M;
        M = temp;
    }
    static void t5() {
        for (int y = 0; y < N/2; y++) {
            for (int x = 0; x < M/2; x++) {
                int tmp = map[y][x];
                map[y][x] = map[y+N/2][x];
                map[y+N/2][x] = map[y+N/2][x+M/2];
                map[y+N/2][x+M/2] = map[y][x+M/2];
                map[y][x+M/2] = tmp;
            }
        }
    }
    static void t6() {
        for (int y = 0; y < N/2; y++) {
            for (int x = 0; x < M/2; x++) {
                int tmp = map[y][x];
                map[y][x] = map[y][x+M/2];
                map[y][x+M/2] = map[y+N/2][x+M/2];
                map[y+N/2][x+M/2] = map[y+N/2][x];
                map[y+N/2][x] = tmp;
            }
        }
    }
}
