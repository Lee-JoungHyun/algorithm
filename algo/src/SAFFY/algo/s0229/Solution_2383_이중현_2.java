package SAFFY.algo.s0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_2383_이중현_2 {
    static class Person {
        int y, x, wait, distance, goStair = 0;
        public Person(int y, int x) {
            this.y = y;
            this.x = x;
        }
        public Person(int y, int x, int wait, int distance) {
            this.y = y;
            this.x = x;
            this.wait = wait;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "y=" + y +
                    ", x=" + x +
                    ", wait=" + wait +
                    ", distance=" + distance +
                    ", goStair=" + goStair +
                    '}';
        }
    }
    static class Stair {
        int y, x, spend;

        public Stair(int y, int x, int spend) {
            this.y = y;
            this.x = x;
            this.spend = spend;
        }
    }
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Person> peaple;
    static Stair[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            peaple = new ArrayList<>();
            stairs = new Stair[2];
            int sCnt = 0;
            int N = Integer.parseInt(br.readLine());
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 1) {
                        peaple.add(new Person(y, x));
                    }
                    else if (tmp != 0) {
                        stairs[sCnt++] = new Stair(y, x, tmp);
                    }
                }
            } // 입력 끝
            makeSet(0, 0, peaple.size());
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
            answer = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }
    static LinkedList<Person> tA;
    static LinkedList<Person> tB;
    private static void makeSet(int cnt, int select, int target) {
        if (cnt == target) {
            tA = new LinkedList<>();
            tB = new LinkedList<>();
            for (int i = 0; i < target; i++) {
                Person tmp = peaple.get(i);
                if ((select & (1 << i)) != 0) {
                    tA.add(new Person(tmp.y, tmp.x, stairs[0].spend, Math.abs(tmp.y - stairs[0].y) + Math.abs(tmp.x - stairs[0].x)));
                }
                else {
                    tB.add(new Person(tmp.y, tmp.x, stairs[1].spend, Math.abs(tmp.y - stairs[1].y) + Math.abs(tmp.x - stairs[1].x)));
                }
            }
            simulation();
            return;
        }
        // 뽑음 (1번 계단)
        makeSet(cnt + 1, select | (1 << cnt), target);
        // 안뽑음 (2번 계단)
        makeSet(cnt + 1, select, target);
    }
    static void simulation() {
        LinkedList<Person> teamA = new LinkedList<>();
        LinkedList<Person> teamB = new LinkedList<>();
        for (Person p : tA) {
            teamA.add(new Person(p.y, p.x, p.wait, p.distance));
        }
        for (Person p : tB) {
            teamB.add(new Person(p.y, p.x, p.wait, p.distance));
        }
        Queue<Person> waitA = new LinkedList<>();
        Queue<Person> waitB = new LinkedList<>();
        LinkedList<Person> stairA = new LinkedList<>();
        LinkedList<Person> stairB = new LinkedList<>();

//        System.out.println("시작");
//        System.out.println("teamA: " + teamA);
//        System.out.println("teamB: " + teamB);
        int time = 2;
        while (time < answer) {
            LinkedList<Person> nxtSA = new LinkedList<>();
            LinkedList<Person> nxtSB = new LinkedList<>();
            LinkedList<Person> nxtA = new LinkedList<>();
            LinkedList<Person> nxtB = new LinkedList<>();
            //if (time > 3) break;
            //1. 계단 진행
            if (!stairA.isEmpty()) {
                for (int i = 0; i < stairA.size(); i++) {
                    Person a = stairA.get(i);
                    if (--a.wait > 0) {
                        nxtSA.add(a);
                    }
                }
            }
            stairA = nxtSA;
            if (!stairB.isEmpty()) {
                for (int i = 0; i < stairB.size(); i++) {
                    Person b = stairB.get(i);
                    if (--b.wait > 0) {
                        nxtSB.add(b);
                    }
                }
            }
            stairB = nxtSB;

            //2. 대기자들 계단에 올리기
            while (!waitA.isEmpty() && stairA.size() < 3) {
                stairA.add(waitA.poll());
            }
            while (!waitB.isEmpty() && stairB.size() < 3) {
                stairB.add(waitB.poll());
            }

            //3. 지도에 있는 사람들 계단으로 다가가기
            for (int i = 0; i < teamA.size(); i++) {
                Person a = teamA.get(i);
                if (--a.distance > 0) {
                    nxtA.add(a);
                } else {
                    if (stairA.size() < 3)
                        stairA.add(a);
                    else
                        waitA.add(a);
                }
            }
            teamA = nxtA;

            for (int i = 0; i < teamB.size(); i++) {
                Person b = teamB.get(i);
                if (--b.distance > 0) {
                    nxtB.add(b);
                } else {
                    if (stairB.size() < 3)
                        stairB.add(b);
                    else
                        waitB.add(b);
                }
            }
            teamB = nxtB;
            // 종료조건
//            System.out.println(time);
//            System.out.println("teamA: " + teamA);
//            System.out.println("teamB: " + teamB);
//            System.out.println("계단A: " + stairA);
//            System.out.println("계단B: " + stairB);
//            System.out.println("A대기" + waitA);
//            System.out.println("B대기" + waitB);
            if (teamA.isEmpty() && teamB.isEmpty() && waitA.isEmpty() && waitB.isEmpty() && stairA.isEmpty() && stairB.isEmpty()) {
                answer = time;
                break;
            }
            time++;
        }

    }

}
