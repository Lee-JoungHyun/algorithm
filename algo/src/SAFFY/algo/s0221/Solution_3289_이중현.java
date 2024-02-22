package SAFFY.algo.s0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_이중현 {

    static int N, M, flag, a, b, parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            flag = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (flag == 0)
                union(a, b);
            else if (find(a) == find(b)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int x = find(a); //x의 부모노드 찾기
        int y = find(b); //y의 부모노드 찾기

        if (x == y) return;
        if (x <= y) parents[y] = x;
        else parents[x] = y;

    }

    static int find(int a) {
        if (a == parents[a])
            return a;
        else
            return parents[a] = find(parents[a]);
    }
}