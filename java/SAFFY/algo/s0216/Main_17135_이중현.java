package SAFFY.algo.s0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17135_이중현 {

    static int N, M, D, answer, max;
    static int origin[][], map[][], archers[] = new int[3], kill[][] = new int[3][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        origin = new int[N][M];
        map = new int[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                origin[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        makeComb(0, 0);
        System.out.println(max);
    }
    static void makeComb(int cnt, int start) {
        if (cnt == 3) {
            //System.out.println(Arrays.toString(archers));
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    map[y][x] = origin[y][x];
                }
            }
            shoot();
            //System.out.println(Arrays.toString(archers) + ": " + answer);
            //System.out.println(answer);
            max = Math.max(max, answer);
            answer = 0;
            return;
        }
        for (int i = start; i < M; i++) {
            archers[cnt] = i;
            makeComb(cnt+1, i+1);
        }
    }
    static void shoot() {
        // 적이 다가옴 = 성이 전진함
        for (int y = N; y > 0; y--) {
            resetKill();
            for (int archer = 0; archer < 3; archer++) {
                selectEnermy(archers[archer], y, archer);
            }
            for (int i = 0; i < 3; i++) {
                //System.out.println("kill[" + i + "]: " + kill[i][0] + ", " + kill[i][1]);
                if (kill[i][0] != -1 && map[kill[i][0]][kill[i][1]] == 1) {
                    map[kill[i][0]][kill[i][1]] = 0;
                    answer++;
                }
            }
            //System.out.println(y + "에 성: " + answer);
        }
    }
    static void selectEnermy(int x, int y, int archer) {
        // 길이 1
        if (map[y-1][x] == 1) {
            kill[archer][0] = y-1;
            kill[archer][1] = x;
            return;
        }//
        // 길이 2 ~ D 까지
        for (int gap = 2; gap <= D; gap++) {
            int nY = y-1;
            int nX = x-(gap-1);
            while (nY < y) {
                //System.out.println(nY + ", " + nX);
                if ((0 <= nY && nY < N && 0 <= nX && nX < M) && map[nY][nX] == 1) {
                    kill[archer][0] = nY;
                    kill[archer][1] = nX;
                    return;
                }
                if(nX < x) nY--;
                else nY++;
                nX++;
            }
        }
    }
    static void resetKill() {
        for (int i = 0; i < 3; i++) {
            kill[i][0] = -1;
            kill[i][1] = -1;
        }
    }
}
