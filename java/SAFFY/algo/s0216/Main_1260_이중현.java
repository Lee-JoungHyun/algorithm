package SAFFY.algo.s0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260_이중현 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        Graph map = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map.addEdge(v - 1, w - 1);
        }
        map.dfs(V - 1);
        System.out.println();
        map.bfs(V - 1);

    }

    static class Graph {
        private int V;
        private LinkedList<Integer>[] graph;

        public Graph(int v) { // LinkedList 배열 만들기
            this.V = v;
            graph = new LinkedList[v];
            for (int i = 0; i < V; i++)
                graph[i] = new LinkedList();
        }

        void addEdge(int v, int w) { // 그래프 연결
            graph[v].add(w);
            graph[w].add(v);
        }

        void dfs(int n) {
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                Collections.sort(graph[i]);
            godfs(n, visited);

        }

        void godfs(int n, boolean visited[]) {
            visited[n] = true;
            System.out.print(n + 1 + " ");

            Iterator<Integer> it = graph[n].listIterator();

            while (it.hasNext()) {
                int d = it.next();
                // 방문하지 않은 노드 로 재귀
                if (!visited[d])
                    godfs(d, visited);
            }
        }

        void bfs(int n) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(n);
            while (queue.size() != 0) {
                int now = queue.poll();
                if (visited[now]) continue;
                visited[now] = true;
                System.out.print(now + 1 + " ");
                Iterator<Integer> it = graph[now].listIterator();
                while (it.hasNext()) {
                    int d = it.next();
                    // 방문하지 않은 노드 로 재귀
                    if (!visited[d])
                        queue.add(d);
                }
            }
        }

    }
}