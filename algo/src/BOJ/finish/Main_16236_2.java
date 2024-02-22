package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_2 {
    static int nowSize = 2, nowY, nowX, map[][], N, eatCnt, answer = 0;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 9) {
                    nowY = y; nowX = x;
                    map[y][x] = 0;
                }
                else
                    map[y][x] = tmp;
            }
        }   // 입력 끝
        while (true) {
            int tmp = eating();
            if (tmp == -1) break;
            answer += tmp;
            map[nowY][nowX] = 0;
            if (nowSize == ++eatCnt) {
                eatCnt = 0;
                nowSize++;
            }
            //System.out.println(nowSize + ", " + eatCnt);
        }
        System.out.println(answer);

    }
    static int eating() {
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[N][N];
        int eatX = N, eatY = N, nX, nY, qsize, depth = 0;
        visited[nowY][nowX] = true;
        queue.add(new int[]{nowY, nowX});
        int[] poz;
        while (!queue.isEmpty()) {
            depth++;
            qsize = queue.size();
            while (qsize-- > 0) {
                poz = queue.poll();
                for (int d = 0; d < 4; d++) {
                    nY = poz[0] + dy[d];
                    nX = poz[1] + dx[d];
                    if (isIn(nY, nX) && !visited[nY][nX] && map[nY][nX] <= nowSize) {
                        // 먹을 상어 찾음
                        if (map[nY][nX] != 0 && map[nY][nX] < nowSize) {
                            if (eatY > nY) {
                                eatY = nY;
                                eatX = nX;
                            } else if (nY == eatY) {
                                if (eatX > nX)
                                    eatX = nX;
                            }
                        }
                        visited[nY][nX] = true;
                        queue.add(new int[]{nY, nX});
                    }
                }
            }
            if (eatX != N) {
                //System.out.println("eat [" + nowY + ", " + nowX + "] +" + depth + " = " + (depth + answer));
                queue.clear();
                nowY = eatY;
                nowX = eatX;
                return depth;
            }
        }
        return -1;
    }
    static boolean isIn(int y, int x) {
        if (0 <= y && y < N && 0 <= x && x < N)
            return true;
        return false;
    }
}
