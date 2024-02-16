package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int N, M, map[][], safety, inputTmp, nxtX, nxtY, answer = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static LinkedList<int[]> virus;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new LinkedList<>();
        safety = -3;
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                inputTmp = Integer.parseInt(st.nextToken());
                if (inputTmp == 0) safety++;
                else if (inputTmp == 2) virus.add(new int[]{y, x});
                map[y][x] = inputTmp;
            }
        }
        makeWall(0, 0);
        System.out.println(answer);

    }
    static void makeWall(int cnt, int start) {
        if (cnt == 3) {
            checkSafety();
            return;
        }
        for (int y = start / M; y < N; y++) {
            for (int x = start % M; x < M; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    makeWall(cnt+1, start);
                    map[y][x] = 0;
                }
            }
        }
    }
    static void checkSafety() {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int spread = 0;
        for (int i = 0; i < virus.size(); i++) {
            queue.add(virus.get(i));
        }
        while (queue.size() != 0) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                nxtY = tmp[0] + dy[i];
                nxtX = tmp[1] + dx[i];
                if (0 <= nxtY && nxtY < N && 0 <= nxtX && nxtX < M && map[nxtY][nxtX] == 0 && !visited[nxtY][nxtX]) {
                    visited[nxtY][nxtX] = true;
                    spread++;
                    queue.add(new int[] {nxtY, nxtX});
                }
            }
        }
        answer = Math.max(answer, safety - spread);
    }
}
