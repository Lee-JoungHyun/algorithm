package SAFFY.algo.s0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_이중현 {
    static int Y, X, answer, nX, nY;
    static char map[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new char[Y][X];
        for (int y = 0; y < Y; y++) {
            map[y] = br.readLine().toCharArray();
        }
        DFS(0, 0, 1, 1<< (map[0][0] - '0'));
        System.out.println(answer);
    }
    static void DFS(int x, int y, int depth, int bit) {
        answer = Math.max(answer, depth);
        for (int d = 0; d < 4; d++) {
            nX = x+dx[d];
            nY = y+dy[d];
            if (0 <= nX && nX < X && 0 <= nY && nY < Y) {
                // 본인이 포함되지 않음
                if ((bit & 1 << (map[nY][nX] - '0')) == 0) {
                    DFS(nX, nY, depth+1, bit | 1<<(map[nY][nX] - '0'));
                }
            }
        }
    }
}
