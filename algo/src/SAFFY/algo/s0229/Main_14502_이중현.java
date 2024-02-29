package SAFFY.algo.s0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14502_이중현 {

    private static class Virus {
        int y, x;
        public Virus(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int safeArea = 0;
        int[][] map = new int[Y][X];
        LinkedList<Virus> vs =new LinkedList<>();
        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 0) safeArea++;
                if (tmp == 2) {
                    vs.add(new Virus(y, x));
                }
                map[y][x] = tmp;
            }
        }

        // 벽세우기
        int wallCnt = 0;

        for (int wall = 0; wall < 3; wall++) {
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {

                }
            }
        }

    }
}
