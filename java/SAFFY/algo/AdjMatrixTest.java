package SAFFY.algo;

import java.util.*;
/*
graph Input 1
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 */
/*
graph Input 2
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
public class AdjMatrixTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] adjMatrix = new int[V][V]; // 인접되지 않은 상태로 초기화
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMatrix[from][to] = adjMatrix[to][from] = 1;
        }
//        for (int[] row : adjMatrix) {
//            System.out.println(Arrays.toString(row));
//        }
        bfs(adjMatrix, 0);

    }
    static void bfs(int[][] adjMAtrix, int start) {
        int V = adjMAtrix.length;
        //1. 큐 방문관리 배열
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        //2. 시작 정점(start) 큐에 넣고 방문체크
        queue.offer(start);
        visited[start] = true;

        //3. 큐로 방문 관리
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println((char) (current + 65));
            for (int i = 0; i < V; i++) {
                if (adjMAtrix[current][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
