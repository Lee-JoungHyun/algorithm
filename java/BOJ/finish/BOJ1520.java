package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int N, M, map[][], answer, nX, nY, dp[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        dp[N-1][M-1] = 1;
        // 입력 끝
        System.out.println(DFS(0, 0));

    }
    static int DFS(int X, int Y) {
        int sum = 0;
        for (int d = 0; d < 4; d++) {
            nX = X+dx[d]; nY = Y+dy[d];
            if (0 <= nX && nX < M && 0 <= nY && nY < N && map[Y][X] > map[nY][nX]) {
                if (dp[nY][nX] == -1)
                    sum += DFS(nX, nY);
                else {
                    sum += dp[nY][nX];
                }
            }
        }
        dp[Y][X] = sum;
        return sum;
    }
}
