package SAFFY.algo.s0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5653_이중현 {
    static class cell implements Comparable<cell>{
        int y, x, power, aliveTime, state, waitTime;
        public cell(int y, int x, int power) {
            this.y = y;
            this.x = x;
            this.power = power;
            this.aliveTime = 0;
            // 0 -> 비활성, 1 -> 활성, 2 -> 사망(버려질듯)
            this.state = 0;
            this.waitTime = 0;
        }
        @Override
        public int compareTo(cell o) {
            // 활성상태일때 주변에 퍼트릴때 power가 높은순임 : power 내림차순
            return o.power - this.power;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof cell) {
                if (this.x == ((cell) obj).x && this.y == ((cell) obj).y)
                    return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "cell{" +
                    "y=" + y +
                    ", x=" + x +
                    ", power=" + power +
                    ", aliveTime=" + aliveTime +
                    ", state=" + state +
                    ", waitTime=" + waitTime +
                    '}';
        }
    }
    static PriorityQueue<cell> aliveCells;
    static ArrayList<cell> waitCells;
    static HashSet<cell> existence;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int nx, ny;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int Y, X, K;
        for (int tc = 1; tc <= T; tc++) {
            aliveCells = new PriorityQueue<>();
            waitCells = new ArrayList<>();
            existence = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int y = 0; y < Y; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < X; x++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v == 0) continue;
                    cell tmp = new cell(y, x, v);
                    waitCells.add(tmp);
                    existence.add(tmp);
                }
            }
            //System.out.println("0s 생존: " + aliveCells.size() + ", 대기: " + waitCells.size());
            for (int sTime = 1; sTime <= K; sTime++) {
                cell tmp;
                PriorityQueue<cell> nxtAlice = new PriorityQueue<>();
                ArrayList<cell> nxtWait = new ArrayList<>();
                // 1. 활성상태인 애들의 번식, 사망
                while (!aliveCells.isEmpty()) {
                    tmp = aliveCells.poll();
                    for (int d = 0; d < 4; d++) {
                        nx = tmp.x + dx[d];
                        ny = tmp.y + dy[d];
                        cell ncell = new cell(ny, nx, tmp.power);
                        // 첫방문한 곳이면
                        if (!existence.contains(ncell)) {
                            existence.add(ncell);
                            nxtWait.add(ncell);
                        }
                    }
                    if (++tmp.aliveTime < tmp.power)
                        nxtAlice.add(tmp);
                }
                // 2. 대기상태인 애들의 갱신, 활성
                for (cell wait : waitCells) {
                    if (++wait.waitTime == wait.power)
                        nxtAlice.add(wait);
                    else
                        nxtWait.add(wait);
                }
                aliveCells = nxtAlice;
                waitCells = nxtWait;
                //System.out.println(sTime + "s 생존: " + aliveCells.size() + ", 대기: " + waitCells.size());
                //System.out.println("산놈들" + aliveCells);
                //System.out.println("기다리는들" + waitCells);
            }
            sb.append("#").append(tc).append(" ").append(waitCells.size() + aliveCells.size()).append("\n");
        }
        System.out.println(sb);

    }

}
