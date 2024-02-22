package SAFFY.algo.s0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_이중현 {
    public static void main(String[] args) throws IOException {
        int[][] map = new int[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int pozX = 99;
        int pozY;
        int tmp;
        boolean[][] visited;
        for (int tc = 0; tc < 10; tc++) {
            pozY = 99;
            visited = new boolean[100][100];
            br.readLine();
            for (int y = 0; y < 100; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 100; x++) {
                    tmp = Integer.parseInt(st.nextToken());
                    map[y][x] = tmp;
                    if (tmp == 2) pozX = x;
                }
            }
            while (pozY != 0) {
                visited[pozY][pozX] = true;
                if (pozX+1 < 100 && !visited[pozY][pozX+1] && map[pozY][pozX+1] == 1) pozX++;
                else if (0 <= pozX-1 && !visited[pozY][pozX-1] && map[pozY][pozX-1] == 1) pozX--;
                else pozY--;
            }
            System.out.println("#" + (tc+1) + " " + pozX);
        }
    }
}
