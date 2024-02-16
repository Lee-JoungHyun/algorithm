package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int N, M, H, map[][][], qsize, nxtX, nxtY, nxtZ, now[], answer, depth;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue;
    static boolean visited[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        answer = N * M * H;
        depth = 0;
        visited = new boolean[H][N][M];
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) {
                        queue.add(new int[]{z, y, x});
                        visited[z][y][x] = true;
                        answer--;
                    } else if (tmp == -1) answer--;
                    map[z][y][x] = tmp;
                }
            }
        }
        ///////////// 입력

        while (queue.size() != 0) {
            qsize = queue.size();
            while (--qsize >= 0) {
                now = queue.poll();
                for (int i = 0; i < 6; i++) {
                    nxtZ = now[0]+dz[i];
                    nxtY = now[1]+dy[i];
                    nxtX = now[2]+dx[i];
                    if (0 <= nxtY && nxtY < N && 0 <= nxtX && nxtX < M && 0 <= nxtZ && nxtZ < H && !visited[nxtZ][nxtY][nxtX] && map[nxtZ][nxtY][nxtX] == 0) {
                        visited[nxtZ][nxtY][nxtX] = true;
                        answer--;
                        queue.add(new int[]{nxtZ, nxtY, nxtX});
                    }
                }
            }
            depth++;
        }
        if (answer == 0)
            System.out.println(depth-1);
        else
            System.out.println(-1);


    }
}
