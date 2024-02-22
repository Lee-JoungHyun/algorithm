package BOJ.finish;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18405 {
    static Queue<int[]>[] queues;
    static int N, K, map[][], tmp, nxtY, nxtX, S, X, Y, qsize[], now[];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queues = new LinkedList[K+1];
        for (int i = 1; i <= K; i++) {
            queues[i] = new LinkedList<>();
        }
        map = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                tmp = Integer.parseInt(st.nextToken());
                map[y][x] = tmp;
                if (tmp == 0) continue;
                queues[tmp].add(new int[]{y, x});
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken())-1;
        X = Integer.parseInt(st.nextToken())-1;
        if (map[Y][X] != 0) {
            System.out.println(map[Y][X]);
            return;
        }
        int depth = 0;
        while (Arrays.stream(getQueueSize()).sum() != 0) {
            qsize = getQueueSize();
            if (depth == S) break;
            for (int q = 1; q <= K; q++) {
                while (qsize[q]-- > 0) {
                    now = queues[q].poll();
                    for (int d = 0; d < 4; d++) {
                        nxtY = now[0] + dy[d];
                        nxtX = now[1] + dx[d];
                        if (0 <= nxtY && nxtY < N && 0 <= nxtX && nxtX < N) {
                            if (nxtX == X && nxtY == Y) {
                                System.out.println(q);
                                return;
                            }
                            if (map[nxtY][nxtX] == 0) {
                                map[nxtY][nxtX] = q;
                                queues[q].add(new int[]{nxtY, nxtX});
                            }
                        }
                    }
                }
            }
            depth++;
        }

//        System.out.println();
//        for (int i = 0; i < N; i++)
//            System.out.println(Arrays.toString(map[i]));
        System.out.println(0);

    }
    static int[] getQueueSize() {
        int[] tmp = new int[K+1];
        for (int i = 1; i <= K; i++) {
            tmp[i] += queues[i].size();
        }
        return tmp;
    }
}
