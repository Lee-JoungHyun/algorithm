package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        for(int y = 0; y < R; y++) {
            char[] line = br.readLine().toCharArray();
            for (int x = 0; x < C; x++) {
                map[y][x] = line[x] - '0';
            }
        }
        boolean[][] totalVisited = new boolean[R][C];
        boolean[][] localVisited = new boolean[R][C];
        int[] dc = {-1, 0, 0, 1};
        int[] dr = {0, -1, 1, 0};
        int answer = 0;
        int aroundMax;
        int nxtR;
        int nxtC;
        Queue<int[]> queue = new LinkedList<>();
        LinkedList<Integer> calc = new LinkedList<>();
        boolean flag = true;
        for(int r = 1; r < R-1; r++) {
            for (int c = 1; c < C - 1; c++) {


            }
        }
        System.out.println(answer);
    }
}
