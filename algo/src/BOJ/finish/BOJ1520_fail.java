package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520_fail {

    public static class Graph {
        int M, N;
        long answer = 0L;
        public int[][] map;
        int[][] canGoEnd;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        public Graph(int M, int N) {
            this.M = M;
            this.N = N;
            this.map = new int[M][N];
            this.canGoEnd = new int[M][N];
        }
        public long goDFS() {
            DFS(0, 0);
            return answer;
        }
        void DFS(int y, int x) {
            int now = map[y][x];
            //canGoEnd[y][x] += 1;
            for (int i = 0; i < 4; i++) {
                int nxtX = x+dx[i];
                int nxtY = y+dy[i];
                if(0 <= nxtX && nxtX < N && 0 <= nxtY && nxtY < M && now > map[nxtY][nxtX]) {

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Graph tmp = new Graph(M, N);
        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                tmp.map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tmp.goDFS());
    }
}

