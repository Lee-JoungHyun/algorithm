package SAFFY.algo.s0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_이중현 {
    static int N, map[][], answer, qsize, depth, nxtX, nxtY, now[], start;
    static boolean visited[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            //visited = new boolean[N][N];
            answer = 0;
            queue = new LinkedList<>();
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            } // 입력 끝
            // BFS -> 나보다 1큰 방이기 때문에 visited 공유 가능
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    //if (visited[y][x]) continue;
                    visited = new boolean[N][N];
                    visited[y][x] = true;
                    queue.add(new int[]{y, x});
                    depth = 0;
                    while (queue.size() != 0) {
                        qsize = queue.size();
                        while (--qsize >= 0) {
                            now = queue.poll();
                            for(int i = 0; i < 4; i++) {
                                nxtY = now[0]+dy[i];
                                nxtX = now[1]+dx[i];
                                if (0 <= nxtY && nxtY < N && 0 <= nxtX && nxtX < N &&
                                        !visited[nxtY][nxtX] && map[nxtY][nxtX] - map[now[0]][now[1]] == 1) {
                                    visited[nxtY][nxtX] = true;
                                    queue.add(new int[]{nxtY, nxtX});
                                }
                            }
                        }
                        depth++;
                    }
                    if (answer < depth || (answer == depth && start > map[y][x])) {
                        start = map[y][x];
                        answer = depth;
                    }
                 }
            }
            sb.append("#").append(tc).append(" ").append(start).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
