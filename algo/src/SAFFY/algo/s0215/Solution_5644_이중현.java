package SAFFY.algo.s0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5644_이중현 {
    static int M, A, man1[], man2[], x1, y1, x2, y2;
    static int bcs[][]; // 정보 x, y, 범위, 충전량
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            init();
            sb.append("#").append(tc).append(" ").append(go()).append("\n");
        }
        System.out.println(sb);
    }
    static int go() {
        int time = 0;
        int charge = 0;
        PriorityQueue<int[]> p1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        PriorityQueue<int[]> p2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        while (true) {
            p1.clear();
            p2.clear();
            //1. 현재상태일때 충전량 계산
            //1-1 현재 본인 주변 충전기 우선순위 queue에 삽입
            for (int i = 0; i < A; i++) {
                if (bcs[i][2] >= calcDis(x1, y1, bcs[i][0], bcs[i][1])) {
                    p1.offer(new int[]{bcs[i][3],i});
                }
                if (bcs[i][2] >= calcDis(x2, y2, bcs[i][0], bcs[i][1])) {
                    p2.offer(new int[]{bcs[i][3],i});
                }
            }
            //1-3 우선순위 큐가 둘다 차있을 경우
            if(p1.size() != 0 && p2.size() != 0) {
                //1-3-1 우선순위 queue의 가장 큰 값이 다를 경우
                if (p1.peek()[1] != p2.peek()[1]) {
                    charge += p1.peek()[0] + p2.peek()[0];
                }
                //1-3-2 같을 경우
                else {
                    // 우선순위 큐의 사이즈가 1을 고려
                    if (p1.size() == 1 && p2.size() == 1) {
                        charge += p1.peek()[0];
                    }
                    else if (p1.size() != 1 && p2.size() != 1) {
                        charge += p1.poll()[0];
                        p2.poll();
                        charge += p1.peek()[0] > p2.peek()[0] ? p1.peek()[0] : p2.peek()[0];
                    }
                    else if (p1.size() != 1) {
                        charge += p1.poll()[0];
                        charge += p1.poll()[0];
                    }
                    else if (p2.size() != 1) {
                        charge += p2.poll()[0];
                        charge += p2.poll()[0];
                    }

                }
            }
            //1-2-1 p1만 존재
            else if (p1.size() != 0) {
                charge += p1.peek()[0];
            }
            //1-2-2 p2만 존재
            else if (p2.size() != 0) {
                charge += p2.peek()[0];
            }

            //System.out.println(time + ", " + charge);
            if (time == M) break;
            //2. x1, x2, y1, y2 변경
            x1 += dx[man1[time]]; y1 += dy[man1[time]];
            x2 += dx[man2[time]]; y2 += dy[man2[time]];
            time++;
        }
        return charge;
    }

    static void init() throws IOException{
        x1 = 1;
        y1 = 1;
        x2 = 10;
        y2 = 10;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        man1 = new int[M];
        man2 = new int[M];
        bcs = new int[A][];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            man1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            man2[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            bcs[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
    }
    static int calcDis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
