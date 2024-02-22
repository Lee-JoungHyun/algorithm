package SAFFY.algo.s0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_이중현 {
    static int N;
    static boolean[][] visited = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            for (int y = startY; y < startY+10; y++) {
                for (int x = startX; x < startX+10; x++) {
                    if (!visited[y][x]) {
                        visited[y][x] = true;
                        answer++;
                    }
                }

            }
        }
        System.out.println(answer);
    }
}
