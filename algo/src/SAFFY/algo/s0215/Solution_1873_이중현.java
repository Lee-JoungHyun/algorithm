package SAFFY.algo.s0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_이중현 {
    static int H, W, X, Y, Dir, task;
    static char map[][], tasks[];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            //System.out.println("시작!");
            for (int i = 0; i < task; i++) {
                //System.out.println(i);
                switch(tasks[i]) {
                    case 'U':
                        Dir = 0;
                        if (0 < Y && map[Y-1][X] == '.') {
                            map[Y][X] = '.';
                            map[--Y][X] = '^';
                        }else map[Y][X] = '^';
                        break;
                    case 'D':
                        Dir = 2;
                        if (Y < H-1 && map[Y+1][X] == '.') {
                            map[Y][X] = '.';
                            map[++Y][X] = 'v';
                        } else map[Y][X] = 'v';
                        break;
                    case 'L':
                        Dir = 3;
                        if (0 < X && map[Y][X-1] == '.') {
                            map[Y][X] = '.';
                            map[Y][--X] = '<';
                        }
                        else map[Y][X] = '<';

                        break;
                    case 'R':
                        Dir = 1;
                        if (X < W-1 && map[Y][X+1] == '.') {
                            map[Y][X] = '.';
                            map[Y][++X] = '>';
                        }
                        else map[Y][X] = '>';
                        break;
                    default:
                        shoot();
                        break;
                }
            }
            sb.append("#").append(tc).append(" ");
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    sb.append(map[y][x]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static void shoot() {
        int gap = 1;
        while (true) {
            int nX = X + dx[Dir]*gap;
            int nY = Y + dy[Dir]*gap;
            if (!(0 <= nX && nX < W && 0 <= nY && nY < H) || map[nY][nX] == '#') return;
            if (map[nY][nX] == '*') {
                map[nY][nX] = '.';
                return;
            }
            gap++;
        }
    }
    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        for(int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == '^') {
                    X = j;
                    Y = i;
                    Dir = 0;
                }
                else if (map[i][j] == 'v') {
                    X = j;
                    Y = i;
                    Dir = 2;
                }
                else if (map[i][j] == '<') {
                    X = j;
                    Y = i;
                    Dir = 3;
                }
                else if (map[i][j] == '>') {
                    X = j;
                    Y = i;
                    Dir = 1;
                }

            }
        }
        task = Integer.parseInt(br.readLine());
        tasks = br.readLine().toCharArray();
    }
}
