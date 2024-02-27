package SAFFY.algo.s0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_이중현 {
    static int N, islands[][], parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        long answer[] = new long[T];
        for (int tc = 0; tc < T; tc++) {
            PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> (int)(o1[2] - o2[2]));
            N = Integer.parseInt(br.readLine());
            boolean visited[] = new boolean[N];

            islands = new int[N][2];
            parents = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i][1] = Integer.parseInt(st.nextToken());
                parents[i] = i;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i][0] = Integer.parseInt(st.nextToken());
            }
            for (int pre = 0; pre < N-1; pre++) {
                for (int post = pre+1; post < N; post++) {
                    pq.add(new double[] {pre, post, clacDis(islands[pre], islands[post])});
                }
            }
            double[] now = pq.poll();
            union((int)now[0], (int)now[1]);
            int visitedcnt = 2;
            double distance = now[2];

            while (visitedcnt < N) {
                now = pq.poll();
                if (union((int)now[0], (int)now[1])) {
                    visitedcnt++;
                    distance += now[2];
                }
            }
            double E = Double.parseDouble(br.readLine());
            answer[tc] = Math.round(distance * E);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append("#").append(i + 1).append(" ").append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
    static boolean union(int i1, int i2) {
        int p1 = find(i1);
        int p2 = find(i2);
        if (p1 == p2) return false;
        parents[p1] = p2;
        return true;
    }
    static int find(int i) {
        if (i == parents[i]) return i;
        return parents[i] = find(parents[i]);
    }
    static double clacDis(int[] i1, int[] i2) {
        return Math.pow(i1[0] - i2[0], 2) + Math.pow(i1[1] - i2[1], 2);
    }

}
