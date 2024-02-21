package SAFFY.algo.s0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_이중현 {
    static int N, an1, an2;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char map[][];
    static boolean visited1[][], visited2[][];
    static Queue<int[]> queue;
    static int startColor; // rgb = 012
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        queue = new LinkedList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visited1[y][x] && visited2[y][x]) continue;
                if (!visited1[y][x]) {
                    BFS1(y, x);
                    an1++;
                }
                if (!visited2[y][x]) {
                    an2++;
                    BFS2(y, x);
                }

            }
        }
        System.out.println(an1 + " " + an2);
    }
    // 일반인 전용
    static void BFS1(int Y, int X) {
        queue.add(new int[]{Y, X});
        int[] now;
        visited1[Y][X] = true;
        char start = map[Y][X];
        while (!queue.isEmpty()) {
            now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nxtY = now[0] + dy[i];
                int nxtX = now[1] + dx[i];
                if (0 <= nxtX && nxtX < N && 0 <= nxtY && nxtY < N && !visited1[nxtY][nxtX] && map[nxtY][nxtX] == start) {
                    // 일반인, 적록 공통 처리
                    visited1[nxtY][nxtX] = true;
                    queue.add(new int[]{nxtY, nxtX});
                }
            }
        }
    }
    static void BFS2(int Y, int X) {
        queue.add(new int[]{Y, X});
        int[] now;
        visited2[Y][X] = true;
        char start = map[Y][X];
        while (!queue.isEmpty()) {
            now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nxtY = now[0] + dy[i];
                int nxtX = now[1] + dx[i];
                if (0 <= nxtX && nxtX < N && 0 <= nxtY && nxtY < N && !visited2[nxtY][nxtX] && check(map[nxtY][nxtX], start)) {
                    // 일반인, 적록 공통 처리
                    visited2[nxtY][nxtX] = true;
                    queue.add(new int[]{nxtY, nxtX});
                }
            }
        }
    }
    static boolean check(char a, char b) {
        if ((a == 'R' && b == 'G') || (a == 'G' && b == 'R') || a == b)
            return true;
        return false;
    }
}
