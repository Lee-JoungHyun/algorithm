package SAFFY.algo.s0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_이중현 {
    static int N, M, insert[];
    static Queue<Integer> queue;
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        insert = new int[N+1];
        graph = new LinkedList[N+1];
        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            graph[pre].add(post);
            insert[post]++;
        }
        //System.out.println(Arrays.toString(insert));
        // 입력 끝
        for (int i = 1; i <= N; i++) {
            if (insert[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (insert[now] == 0) {
                sb.append(now).append(" ");
                for (int nxt : graph[now]) {
                    if (--insert[nxt] == 0)
                        queue.add(nxt);
                }
            }
            //System.out.println(Arrays.toString(insert));
        }
        for (int i = 1; i <= N; i++) {
            if (insert[i] != 0) {
                sb.append(insert[i]).append(" ");
            }
        }
        System.out.println(sb);

    }
}
