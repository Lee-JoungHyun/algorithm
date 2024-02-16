package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1707 {
    public static class Graph {
        LinkedList<Integer>[] a;
    }
    public static void main(String[] args) throws IOException {

        LinkedList<Integer>[] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V, K, tmp1, tmp2, depth, qsize, now, nxt;
        boolean flag;
        boolean[] visited;
        Queue<Integer> queue;
        HashSet<Integer> A;
        HashSet<Integer> B;
        int Tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < Tc; t++) {
            flag = true;
            queue = new LinkedList<>();
            depth = 0;
            A = new HashSet<>();
            B = new HashSet<>();
            //1. 인접 리스트로 그래프 받기
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new LinkedList[V + 1];
            for (int i = 0; i < V + 1; i++)
                graph[i] = new LinkedList();
            visited = new boolean[V + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                tmp1 = Integer.parseInt(st.nextToken());
                tmp2 = Integer.parseInt(st.nextToken());
                graph[tmp1].add(tmp2);
                graph[tmp2].add(tmp1);
            }
            //2. 1번째 노드 Queue에 넣고 BFS 시작
            for (int v = 1; v < V + 1; v++) {
                if(!visited[v])
                    queue.add(v);
                while (queue.size() != 0) {
                    qsize = queue.size();
                    for (int i = 0; i < qsize; i++) {
                        //3. 방문 처리후 depth 가 짝수면 A, 홀수면 B 처리
                        now = queue.poll();

                        visited[now] = true;
                        if (depth % 2 == 0) A.add(now);
                        else B.add(now);
                        //4. 현재 노드와 연결되 있는 노드 순회하며
                        // 다음 노드가 나와 같은 HashSet 에 이미 존재하면 No, 없는데 visited 가 false 면 queue 에 삽입
                        Iterator<Integer> it = graph[now].listIterator();
                        while (it.hasNext()) {
                            nxt = it.next();
                            // 다음 노드 처리
                            if ((depth % 2 == 0 && A.contains(nxt)) || (depth % 2 == 1 && B.contains(nxt))) {
                                flag = false;
                                i = qsize;
                                queue.clear();
                                break;
                            }
                            if (!visited[nxt]) queue.add(nxt);
                        }
//                        System.out.println(now);
//                        System.out.println(A.toString());
//                        System.out.println(B.toString());
                    }
                    depth++;
                }
            }
            if (flag) System.out.println("YES");
            else System.out.println("NO");

        }

    }
}
