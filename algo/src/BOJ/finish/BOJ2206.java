package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static char[][] map;
    public static boolean[][] visited1, visited2;   // 1은 벽을 안부순 visited, 2는 벽을 부순 visited
    public static int answer = Integer.MAX_VALUE;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited1 = new boolean[N][M];
        visited2 = new boolean[N][M];
        if (N == 1 && M == 1) {
            int xx = Integer.parseInt(br.readLine());
            System.out.println(1);
            return;

        }
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }


        int[] start = {0, 0, 0};
        int[] now;
        int nxtx, nxty, qsize;
        int depth = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited1[0][0] = true;
        visited2[0][0] = true;
        while (queue.size() != 0) {
            qsize = queue.size();
            for (int z = 0; z < qsize; z++) {
                now = queue.poll();
                //System.out.println(now[0] + ", " + now[1] + ": " + depth + " - " + now[2]);
                for (int i = 0; i < 4; i++) {
                    nxty = now[0] + dy[i];
                    nxtx = now[1] + dx[i];
                    if (0 <= nxty && nxty < N && 0 <= nxtx && nxtx < M) {
                        if (nxty == N - 1 && nxtx == M - 1) {
                            System.out.println(depth+1);
                            return;
                        }
                        if (now[2] == 0 && !visited1[nxty][nxtx]) {  // 벽 안뚫
                            visited1[nxty][nxtx] = true;
                            visited2[nxty][nxtx] = true;
                            int[] tmp;
                            if (map[nxty][nxtx] == '0') tmp = new int[]{nxty, nxtx, 0};
                            else tmp = new int[]{nxty, nxtx, 1};
                            queue.add(tmp);
                        }else if (now[2] == 1 && map[nxty][nxtx] == '0' && !visited2[nxty][nxtx]) {  // 벽 뚫
                            int[] tmp = new int[]{nxty, nxtx, 1};
                            visited2[nxty][nxtx] = true;
                            queue.add(tmp);
                        }
                    }
                }
            }
            depth++;
        }
        System.out.println(-1);
    }
}
