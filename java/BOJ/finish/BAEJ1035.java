package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BAEJ1035 {
    public boolean checkStar(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size; j++) {
                if (i==j) continue;
                if (Math.abs(array[i][0] - array[j][0]) + Math.abs(array[i][1] - array[i][0]) == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        class Star {
            public int x, y;
            public boolean visited[][] = new boolean[5][5];
            public Star(int y, int x) {
                this.x = x;
                this.y = y;
                visited[y][x] = true;
            }
        }
        class mapStatus {
            public Star[] stars;
            public int cnt = 0;
            public mapStatus(Star[] start) {
                this.stars = start;
            }
            public mapStatus(Star[] start, int cnt) {
                this.stars = start;
                this.cnt = cnt;
            }
            public boolean checkMap() {
                for (int i = 0; i< stars.length; i++) {
                    boolean flag = true;
                    for (int j=0; j<stars.length; j++) {
                        if (i==j) continue;
                        if ((Math.abs(stars[i].y - stars[j].y) + Math.abs(stars[i].x - stars[j].x)) == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return false;
                    }
                }
                return true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int starCnt = 0;
        Star[] stars = new Star[5];
        //visited = {x, y, num}
        for (int i = 0; i < 5; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                if (tmp[j] == '*') {
                    Star s = new Star(i, j);
                    stars[starCnt++] = s;
                }
            }
        }// 별 갯수, 좌표, 별마다의 visited[][] 배열 생성
        mapStatus ms = new mapStatus(Arrays.copyOf(stars, starCnt));
        System.out.println(starCnt);
        Queue<mapStatus> queue = new LinkedList<>();
        queue.add(ms);

        while (queue.size() != 0) {
            mapStatus now = queue.poll(); //Star[], cnt
            System.out.println(now.cnt);
            if (now.checkMap()) {
                System.out.println(now.cnt);
                return;
            }
            Star[] nowStar = now.stars;
            int nowCnt = now.cnt;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {-1, 0, 1, 0};
            for (int i = 0; i < starCnt; i++) {
                System.out.println(nowStar[i].y + ", " + nowStar[i].x);
                for (int k = 0; k < 4; k++) {
                    System.out.println(nowStar[i].y + ", " + nowStar[i].x);
                    int nxtX = nowStar[i].x+dx[k];
                    int nxtY = nowStar[i].y+dy[k];
                    System.out.println(nxtY + ", " + nxtX + ", " + nowCnt);
                    if (0 <= nxtX && nxtX < 5 && 0 <= nxtY && nxtY < 5 && !nowStar[i].visited[nxtY][nxtX]) {
                        Star[] nxtStar = new Star[starCnt];
                        for (int j = 0; j < starCnt; j++) {

                        }
                        //Star[] nxtStar = nowStar.clone();
                        nxtStar[i].x = nxtX;
                        nxtStar[i].y = nxtY;
                        nxtStar[i].visited[nxtY][nxtX] = true;
                        mapStatus nxtMS = new mapStatus(nxtStar, nowCnt+1);
                        if (nxtMS.checkMap()) {
                            System.out.println(nxtMS.cnt);
                            return;
                        }
                        queue.add(nxtMS);
                    }
                }
            }
        }
        System.out.println("엥 끝??");
    }
}
