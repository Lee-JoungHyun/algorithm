package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6087 {
    static int Y, X, startX, startY, endX, endY, distance[][], nx, ny;
    static char map[][], tmp[];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        map = new char[Y][];
        boolean flag = false;
        distance = new int[Y][X];
        for (int y = 0; y < Y; y++) {
            Arrays.fill(distance[y], 999999999);
            tmp = br.readLine().toCharArray();
            for (int x = 0; x < X; x++) {
                if (tmp[x] == 'C') {
                    if (flag) {
                        endY = y;
                        endX = x;
                    }
                    else {
                        startX = x;
                        startY = y;
                        flag = true;
                    }
                }
            }
            map[y] = tmp;
        }// 입력 끝
        System.out.println(dij());

    }
    static int dij() {
        distance[startY][startX] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < 4; i++) {
            ny = startY + dy[i];
            nx = startX + dx[i];
            if (isIn(ny, nx)) {
                pq.add(new int[]{ny, nx, 0, i});
                distance[ny][nx] = 0;
            }
        }
        // 초기 처리
        int now[];
        while (!pq.isEmpty()) {
            now = pq.poll();
            for (int i = 0; i < 4; i++) {
                ny = now[0] + dy[i];
                nx = now[1] + dx[i];
                if (isIn(ny, nx) && distance[ny][nx] >= (now[2] + i == now[3] ? 0 : 1)) {
                    distance[ny][nx] = now[2] + (i == now[3] ? 0 : 1);
                    pq.add(new int[]{ny, nx, distance[ny][nx], i});
                    if (ny == endY && nx == endX) {
                        pq.clear();
                        break;
                    }
                }
            }
//            for (int i = 0; i < Y; i++)
//                System.out.println(Arrays.toString(distance[i]));
//            System.out.println();
        }
        return distance[endY][endX];
    }
    static boolean isIn(int y, int x) {
        if (!(0 <= x && x < X && 0 <= y && y < Y) || map[y][x] == '*') {
            return false;
        }
        return true;
    }
}
