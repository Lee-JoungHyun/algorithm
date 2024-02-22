package SAFFY.algo.s0131;

import java.util.Scanner;

public class Solution_1954_이중현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, dir, x, y, nxtx, nxty;
        int[][] map;
        boolean[][] visited;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt;
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];
            dir = 0;
            cnt = 1;
            y = 0;
            x = 0;
            while (true) {
                map[y][x] = cnt++;
                visited[y][x] = true;
                nxty = y+dy[dir];
                nxtx = x+dx[dir];
                if(0 <= nxtx && nxtx < N && 0 <= nxty && nxty < N && !visited[nxty][nxtx]) {
                    y = nxty;
                    x = nxtx;
                }else {
                    dir = (dir+1)%4;
                    y = y+dy[dir];
                    x = x+dx[dir];
                    if (0 > y || y >= N || 0 > x || y >= N || visited[y][x]) break;
                }
            }
            System.out.println("#" + tc);
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
}
