package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEJ1189 {
    public static void main(String[] args) throws IOException{
        class Graph {
            int R, C, K;
            int answer = 0;
            char[][] maps;
            boolean[][] visited;
            public Graph(int R, int C, int K) {
                this.R = R;
                this.C = C;
                this.K = K;
                this.maps = new char[R][C];
                this.visited = new boolean[R][C];
            }
            public void inputMap(int i, char[] map)  {
                maps[i] = map;
            }
            public void dfs() {
                int[] pozNow = {R-1, 0, 1};
                visited[pozNow[0]][pozNow[1]] = true;
                goDFS(pozNow);
            }
            public void goDFS(int[] pozNow) {
                int dx[] = {0, 1, 0, -1};
                int dy[] = {1, 0, -1, 0};
                visited[pozNow[0]][pozNow[1]] = true;
                for (int i=0; i<4; i++) {
                    if (0<=pozNow[0]+dy[i] && pozNow[0]+dy[i]<R && 0<=pozNow[1]+dx[i] && pozNow[1]+dx[i] < C && !visited[pozNow[0]+dy[i]][pozNow[1]+dx[i]] && maps[pozNow[0]+dy[i]][pozNow[1]+dx[i]] == '.') {
                        int[] nxt = {pozNow[0]+dy[i], pozNow[1]+dx[i], pozNow[2]+1};
//                        System.out.println(nxt[0] + ", " + nxt[1] + ", " + nxt[2]);
                        if (nxt[2] == K) {
                            if(nxt[0] == 0 && nxt[1] == C-1) {
                                //System.out.println(nxt[0] + ", " + nxt[1] + ", " + nxt[2]);
                                answer++;
                            }
                            visited[pozNow[0]][pozNow[1]] = false;
                            continue;
                        }
                        goDFS(nxt);
                        visited[pozNow[0]+dy[i]][pozNow[1]+dx[i]] = false;
                    }
                }

            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Graph gp = new Graph(R, C, K);
        for (int i = 0; i<R; i++)
            gp.inputMap(i, br.readLine().toCharArray());
        gp.dfs();
        System.out.println(gp.answer);

    }
}
