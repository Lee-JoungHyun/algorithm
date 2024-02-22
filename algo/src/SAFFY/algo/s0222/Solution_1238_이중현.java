package SAFFY.algo.s0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1238_이중현 {
    static int length, start, from, to, max;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            queue = new LinkedList<>();
            graph = new ArrayList[101];
            visited = new boolean[101];
            for (int i = 1; i <= 100; i++)
                graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            visited[start] = true;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length/2; i++) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }// 입력 끝

            // BFS로 그래프 탐색 시작!
            queue.add(start);
            int end;
            while (!queue.isEmpty()) {
                // depth 구분을 위한 qsize 사용
                int qsize = queue.size();
                // 같은 depth에서의 Max값을 받기 위한 변수
                max = Integer.MIN_VALUE;
                // 1depth 반복
                while (qsize-- > 0) {
                    end = queue.poll();
                    // Max값 초기화
                    max = Math.max(end, max);
                    // 다음 연결된 노드중 방문 안된것 방문처리 + queue에 삽입
                    for (int nxt : graph[end]) {
                        if(visited[nxt]) continue;
                        visited[nxt] = true;
                        queue.add(nxt);
                    }
                }
            }
            // 마지막 Depth에서의 MAX값 출력
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
