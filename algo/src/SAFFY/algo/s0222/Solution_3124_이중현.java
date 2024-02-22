package SAFFY.algo.s0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_이중현 {

    static int V, E, parents[];
    static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            pq.clear();
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.add(new int[]{f, t, w});
            }
            int[] edge;
            makeSet();
            int cnt = 0;
            long answer = 0;
            while (!pq.isEmpty()) {
                edge = pq.poll();
                //System.out.println(Arrays.toString(edge));
                if (union(edge[0], edge[1])) {
                    //System.out.println(edge[2]);
                    answer += edge[2];
                    if(++cnt == V-1) break;
                }

            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    public static int find(int a) { // a의 루트 찾기
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    public static boolean union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap == bp) return false;
        parents[ap] = bp; // 부모의 부모 = 대표자의 부모
        return true;
    }
    static void makeSet() {
        parents = new int[V+1];
        for (int i = 1; i <= V; i++)
            parents[i] = i;
    }
}
