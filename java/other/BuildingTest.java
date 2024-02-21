package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t < tc+1; t++) {
            int n = Integer.parseInt(br.readLine());
            char[][] map = new char[n][n];
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    map[y][x] = st.nextToken().charAt(0);
                }
            }
            int hightMax = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    //1. 위에 다 확인 (0, x) ~ (n, x)
                    //2. 옆에 다 확인 (y, 0) ~ (y, n)
                    if (map[y][x] == 'G') continue;
                    int hight = -1;
                    //1. 위에, 옆에
                    for (int i = 0; i < n; i++) {

                        if (map[i][x] == 'B') hight++;
                        if (map[y][i] == 'B') hight++;
                    }
                    //3. 주변 정원 확인
                    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
                    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
                    for (int i = 0; i < 8; i++) {
                        if (0 <= x+dx[i] && x+dx[i] < n && 0 <= y+dy[i] && y+dy[i] < n && map[y+dy[i]][x+dx[i]] == 'G') {
                            hight = 2;
                            break;
                        }
                    }
                   if (hightMax < hight) hightMax = hight;

                }
            }
            System.out.println("#" + t + " " + hightMax);
        }
    }
}
