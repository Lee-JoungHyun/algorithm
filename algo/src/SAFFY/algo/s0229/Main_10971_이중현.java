package SAFFY.algo.s0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_이중현 {

    static int answer = Integer.MAX_VALUE, N;
    static int path[], W[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                W[y][x] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        //1. 싸이클이 생기지 않게 다익스트라? -> 돌아오는 것도 고려해야 해서 안됨
        // -> 그냥 조합
        for (int i = 0; i < N; i++) {
            path = new int[N];
            perm(0, new boolean[N]);
        }
        System.out.println(answer);
    }
    static void perm(int cnt, boolean[] visited) {
        if (cnt  == visited.length){
            calc();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[cnt] = i;
                perm(cnt + 1, visited);
                visited[i] = false;
            }
        }
    }
    static void calc() {
        if (W[path[N-1]][path[0]] == 0) return;
        int cost = W[path[N-1]][path[0]];
        for (int i = 0; i < N-1; i++) {
            if (W[path[i]][path[i + 1]] == 0) return;
            cost += W[path[i]][path[i + 1]];
            if (cost > answer) return;
        }
        answer = cost;
    }

}
