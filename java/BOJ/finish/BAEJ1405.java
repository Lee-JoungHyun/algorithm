package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEJ1405 {
    public static class Robot {
        int[][] visited;
        int cntMax;
        int x;
        int y;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[] dir = new int[4];
        int crush = 0;
        double answer = 0;
        public Robot(int cntMax, int E, int W, int S, int N) {
            this.cntMax = cntMax;
            visited = new int[cntMax*2+1][cntMax*2+1];
            visited[cntMax][cntMax] = 1;
            this.x = cntMax;
            this.y = cntMax;
            this.dir[0] = E;
            this.dir[1] = W;
            this.dir[2] = S;
            this.dir[3] = N;
        }

        public void goDFS() {
            for (int i = 0; i < 4; i++) {
                if (dir[i] != 0) {
                    DFS(this.y + dy[i], this.x + dx[i], (dir[i]/100.0), 1);
                }
            }
        }

        public void DFS(int y, int x, double per, int cnt) {
            //System.out.println(cnt);

            if(visited[y][x] >= 1) {
                return;
            }
            if (cnt == this.cntMax) {
                //System.out.println(y + ", " + x + ": " + per);
                this.answer += per;
                return;
            }
            visited[y][x] += 1;
            for (int i = 0; i < 4; i++) {
                if (dir[i] != 0) {
                    DFS(y + dy[i], x + dx[i], per * (dir[i]/100.0), cnt + 1);
                }
            }
            visited[y][x] -= 1;
            return;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cntMax = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // DFS 로 끝까지 진행하다 visited 2번 방문하면 ???-> 죽여??
        Robot rb = new Robot(cntMax, E, W, S, N);
        rb.goDFS();
        System.out.println(rb.answer);
    }
}
