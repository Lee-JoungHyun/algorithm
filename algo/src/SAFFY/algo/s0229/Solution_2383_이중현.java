package SAFFY.algo.s0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_2383_이중현 {
    private static class stair {
        int y, x, spend, stairCnt;
        public stair(int y, int x, int spend) {
            this.y = y;
            this.x = x;
            this.spend = spend;
        }
    }
    private static class man implements Comparable<man> {
        int y, x, distance, waitTime = 0;

        public man(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(man o) {
            return this.distance - o.distance;
        }

        @Override
        public String toString() {
            return "man{" +
                    "y=" + y +
                    ", x=" + x +
                    ", distance=" + distance +
                    ", waitTime=" + waitTime +
                    '}';
        }
    }
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i < t + 1; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            man[] mans = new man[10];
            stair[] stairs = new stair[2];
            int manCnt = 0;
            int stairCnt = 0;
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) {
                        mans[manCnt++] = new man(y, x);
                    }
                    else if (tmp != 0) {
                        stairs[stairCnt++] = new stair(y, x, tmp);
                    }

                    map[y][x] = tmp;
                }
            } // 입력
            makeSet(0, 0, manCnt, mans, stairs);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
            answer = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }

//    private static int tc(int n, man[] mans, stair[] stairs, int[][] map) {
//        //1. 계단1, 계단2 로 갈 사람을 부분집합으로 뽑아 거리 구해 팀나누기
//
//
//    }
    private static void makeSet(int cnt, int select, int target, man[] mans, stair[] stairs) {
        if (cnt == target) {
            //PriorityQueue<man> teamA = new PriorityQueue<>();
            //PriorityQueue<man> teamB = new PriorityQueue<>();
            ArrayList<man> teamA = new ArrayList<>();
            ArrayList<man> teamB = new ArrayList<>();
            for (int i = 0; i < target; i++) {
                if ((select & (1 << i)) != 0) {
                    mans[i].distance = Math.abs(mans[i].x - stairs[0].x) + Math.abs(mans[i].y - stairs[0].y);
                    mans[i].waitTime = 0;
                    teamA.add(mans[i]);
                }
                else {
                    mans[i].distance = Math.abs(mans[i].x - stairs[1].x) + Math.abs(mans[i].y - stairs[1].y);
                    mans[i].waitTime = 0;
                    teamB.add(mans[i]);
                }
            }
            //3. 해당 값들로 시뮬레이션을 돌리기
            simulation(teamA, teamB, stairs);
            return;
        }
        // 뽑음 (1번 계단)
        makeSet(cnt + 1, select | (1 << cnt), target, mans, stairs);
        // 안뽑음 (2번 계단)
        makeSet(cnt + 1, select, target, mans, stairs);
    }
    static void simulation(ArrayList<man> teamA, ArrayList<man> teamB, stair[] stairs) {
        int time = 0;
        int outACnt = 0, outBCnt = 0;
        LinkedList<man> stairA = new LinkedList<>();
        LinkedList<man> stairB = new LinkedList<>();
        Queue<man> waitA = new LinkedList<>();
        Queue<man> waitB = new LinkedList<>();
        while (time < answer) {

            //1. 계단에 가려고 대기중인 애들 계단에 올리기
            while (!waitA.isEmpty() && stairA.size() < 3)
                stairA.add(waitA.poll());
            while (!waitB.isEmpty() && stairB.size() < 3)
                stairB.add(waitB.poll());

            int idx = 0;
            while (!waitB.isEmpty() && idx < teamA.size()) {
                if(--teamA.get(idx).distance == 0) {
                    waitA.add(teamA.get(idx));
                    teamA.remove(idx);
                }
                else idx++;
            }

            //2. 계단 사람들 먼저 내려보내기
            idx = 0;
            while (idx < stairA.size()) {
                if (++stairA.get(idx).waitTime == stairs[0].spend) {
                    stairA.remove(idx);
                }
                else {
                    idx++;
                }
            }
            idx = 0;
            while (idx < stairB.size()) {
                if (++stairB.get(idx).waitTime == stairs[0].spend) {
                    stairB.remove(idx);
                }
                else {
                    idx++;
                }
            }
            //3-1. teamA 에 있는 사람들 거리 -1씩 하며 0인 애들은 계단에 올리기
            for (man a : teamA) {
                if (--a.distance == 0) {
                    outACnt++;
                    waitA.add(a);
                }
            }
            //3-2. teamB 에 있는 사람들 거리 -1씩 하며 0인 애들은 계단에 올리기
            for (man b : teamB) {
                if (--b.distance == 0) {
                    outACnt++;
                    waitB.add(b);
                }
            }
            if (outACnt == teamA.size() && outBCnt == teamB.size() && stairA.isEmpty() && stairB.isEmpty()) {
                answer = time;
                return;
            }

//            System.out.println(time);
//            System.out.println(stairA);
//            System.out.println(waitA);
//            System.out.println(stairB);
//            System.out.println(waitB);

            time++;
        }

    }

}
