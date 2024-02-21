package SAFFY.algo.s0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_이중현 {
    static int cheeseSize, Y, X, now[], nxtX, nxtY, meltCheese[];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> queue;
    static boolean map[][], visited[][]; // 치즈는 true, 빈칸은 false
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new boolean[Y][X];
        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                if (st.nextToken().equals("1")) {
                    map[y][x] = true;
                    cheeseSize++;
                }
            }
        }
        meltCheese = new int[]{0, 0};
        int answer = 0;
        int cnt = 0;

        // 치즈 녹이기 시작!
        while (cheeseSize > 0) {
            answer = cheeseSize;
            melting();
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(answer);
    }

    // 0, 0부터 target(visited) 을 탐색하고 그것을 togo(visited)로 바꿔줌
    static void melting() {
        visited = new boolean[Y][X];
        // 외부 공기만 들어있을 queue
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            now = queue.poll();
            for (int i = 0; i < 4; i++) {
                nxtY = now[0] + dy[i];
                nxtX = now[1] + dx[i];
                if (0 <= nxtY && nxtY < Y && 0 <= nxtX && nxtX < X && !visited[nxtY][nxtX]) {
                    // 치즈면 녹이고 방문처리, 치즈사이즈 -1
                    if (map[nxtY][nxtX]) {
                        map[nxtY][nxtX] = false;
                        visited[nxtY][nxtX] = true;
                        cheeseSize--;
                    }
                    // 공기면 방문처리 후 queue에 삽입
                    else {
                        visited[nxtY][nxtX] = true;
                        queue.add(new int[]{nxtY, nxtX});
                    }
                }
            }
        }

    }
}

