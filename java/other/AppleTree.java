package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleTree {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        char[][] farm = new char[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                farm[y][x] = st.nextToken().charAt(0);
            }
        }
        int maxPoint = 0;
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                int point = farm[i][j] - '0';
                for (int dir = 0; dir < 4; dir++) {
                    if (0 <= j+dx[dir] && j+dx[dir] < N && 0 <= i+dy[dir] && i+dy[dir] < N) {
                        point += farm[i+dy[dir]][j+dx[dir]] - '0';
                    }
                }
                if (maxPoint < point) maxPoint = point;
            }
        }
        System.out.println(maxPoint);
    }
}
