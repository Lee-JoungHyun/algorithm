package SAFFY.algo.s0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_이중현 {
    static int N, M, K, map[][], calc[][], tmp[][], task[], answer;
    static boolean pervisited[];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[N][M];
        calc = new int[K][3];
        task = new int[K];
        pervisited = new boolean[K];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            calc[i][0] = Integer.parseInt(st.nextToken())-1;
            calc[i][1] = Integer.parseInt(st.nextToken())-1;
            calc[i][2] = Integer.parseInt(st.nextToken());
        } // 입력 끝
        // 1. 연산 순서 뽑기
        // 2. 연산 순서대로 수행해서 min값 찾기
        permutation(0);
        System.out.println(answer);
    }
    static void makeAnswer() {
        for (int y = 0; y < N; y++)
            answer = Math.min(answer, Arrays.stream(tmp[y]).sum());
    }
    private static void permutation(int cnt) {
        if (cnt == K) {
//            System.out.println("========================================================");
//            System.out.println(Arrays.toString(task));
            tmp = new int[N][M];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    tmp[y][x] = map[y][x];
                }
            }
            for (int i = 0; i < K; i++) {
                turnMap(calc[task[i]][0], calc[task[i]][1], calc[task[i]][2]);

//                for (int j = 0; j < N; j++)
//                    System.out.println(Arrays.toString(tmp[j]));
//                System.out.println();
            }

            //System.out.println("========================================================");
            makeAnswer();
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!pervisited[i]) {
                pervisited[i] = true;
                task[cnt] = i;
                permutation(cnt + 1);
                pervisited[i] = false;
            }
        }
    }
    static void turnMap(int r, int c, int s) {
        // c 중심으로 회전
        for (int gap = s; gap > 0; gap--) {
            int dir = 0;
            int past = tmp[r - gap][c - gap];
            tmp[r - gap][c - gap] = tmp[r - gap + 1][c - gap];
            int y = r - gap;
            int x = c - gap + 1;
            while (!(y == r - gap && x == c - gap)) {
                int a = tmp[y][x];
                tmp[y][x] = past;
                past = a;
                if((y == r-gap && x == c+gap) || (y == r+gap && x == c+gap) || (y == r+gap && x == c-gap))
                    dir = (dir+1)%4;
                x += dx[dir];
                y += dy[dir];
            }
        }
    }
}
