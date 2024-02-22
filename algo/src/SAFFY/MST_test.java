package SAFFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
 */
public class MST_test {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            //return Integer.compare(this.weight, o.weight);
            return this.weight - o.weight;
        }
    }
    static int V, parents[];
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(f, t, w);
        }// 간선 리스트 생성
        Arrays.sort(edges);
        // 1. make - set
        makeSet();
        // 2. 정렬된 간선 꺼내 신장트리 만들기
        int answer = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) {
                //System.out.println(edge.weight);
                answer += edge.weight;
                if(++cnt == V-1) break;
            }
        }
        System.out.println(answer);
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
    public static void makeSet() {
        parents = new int[V]; // 자신의 부모, 루트 저장(경로압축 ㅇㅇ)
        for (int i = 0; i < V; i++) parents[i] = i;
    }
}
