package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_승현 {
    static char[][] road;
    static boolean[][] visited;
    static int R, C;
    static int max = 0;
    static int[] dx = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        road = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char tmp = str.charAt(j);
                road[i][j] = tmp;
                if (tmp == 'x') {
                    visited[i][j] = true;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            if (!visited[i][0])
                dfs(i, 0, i);
        }
        System.out.println(max);
    }
    private static boolean dfs(int x, int y, int startX) {

        //System.out.println(x + ", " + y + " - " + startX);
        //순회가 마지막 열로 들어오면 다음 행의 0번째로 dfs를 돌리면서 cnt + 1 시켜줌

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];             //행은 상, 0, 하로 이동(dx)
            int ny = y + 1;                 //열은 1개만 증가하므로 +1만
            if (!isIn(nx, ny)) {            //배열안의 숫자인지
                continue;
            }
            if (!visited[nx][ny]) {         //방문하지 않았으면
                visited[nx][ny] = true;     //방문처리
                if (ny == C-1) {
                    max += 1;
                    return true;
                }
                if (dfs(nx, ny, startX)) break;//다음 좌표에서 다시 dfs
            }
        }
        return true;
    }
    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}