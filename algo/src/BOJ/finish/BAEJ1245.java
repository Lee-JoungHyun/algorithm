package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEJ1245 {
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int nxtY;
        int nxtX;
        int answer = 0;
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                Queue<int[]> queue = new LinkedList<>();
                int[] tmp = {i, j};
                queue.add(tmp);
                boolean flag = true;
                while (queue.size() != 0) {
                    int[] pozNow = queue.poll();
                    for (int d = 0; d < 8; d++) {
                        nxtY = pozNow[0]+dy[d];
                        nxtX = pozNow[1]+dx[d];
                        if (0 <= nxtY && nxtY < N && 0 <= nxtX && nxtX < M) {
                            if(map[nxtY][nxtX] < map[pozNow[0]][pozNow[1]]) {
                            }else if(map[nxtY][nxtX] == map[pozNow[0]][pozNow[1]]) {
                                if (!visited[nxtY][nxtX]) {
                                    int[] tmp2 = {nxtY, nxtX};
                                    queue.add(tmp2);
                                }
                            }else{
                                flag = false;
                            }
                        }
                    }visited[pozNow[0]][pozNow[1]] = true;
                }
                if (flag) {
                    //System.out.println(i + ", " + j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
