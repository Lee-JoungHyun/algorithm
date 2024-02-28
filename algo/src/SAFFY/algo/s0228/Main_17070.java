package SAFFY.algo.s0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070 {
    static int dx[] = new int[]{1, 1, 0};
    static int dy[] = new int[]{0, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] visited = new int[3][N][N];
        visited[0][0][1] = 1;
        Queue<int[]> queue = new LinkedList<>();
        int now[], ny, nx, ns;
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            now = queue.poll();
            int start, end;
            if (now[0] == 0) {start = 0; end = 1;}
            else if (now[0] == 1) {start = 0; end = 2;}
            else {start = 1; end = 2;}
            for (int i = start; i <= end; i++) {
                ns = i; ny = now[1] + dy[i]; nx = now[2] + dx[i];
//                System.out.println(ns + ", " + ny + ", " + nx);
                if (canGo(ns, ny, nx, N, map)) {
                    if (visited[ns][ny][nx] == 0)
                        queue.add(new int[]{ns, ny, nx});
                    visited[ns][ny][nx] += visited[now[0]][now[1]][now[2]];
                }
            }
        }

        System.out.println();
        for (int y = 0; y < N; y++)
            System.out.println(Arrays.toString(visited[0][y]));
        System.out.println();
        for (int y = 0; y < N; y++)
            System.out.println(Arrays.toString(visited[1][y]));
        System.out.println();
        for (int y = 0; y < N; y++)
            System.out.println(Arrays.toString(visited[2][y]));


        System.out.println(visited[0][N-1][N-1] + visited[1][N-1][N-1] + visited[2][N-1][N-1]);
    }

    static boolean canGo(int state, int y, int x, int N, int[][] map) {
        if (1 <= x && x < N && 0 <= y && y < N && map[y][x] == 0) {
            if (state == 1) {
                if (map[y][x] == 0 && map[y-1][x] == 0 && map[y][x-1] == 0)
                    return true;
            }
            else {
                if (map[y][x] == 0)
                    return true;
            }
        }
        return false;
    }

}
//fx == N || fy == N ||