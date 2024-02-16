package SAFFY.algo.s0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_이중현 {
    static int R, C, answer;
    static char map[][];
    static int[] dy = {-1, 0, 1};
    static boolean visited[][], finish[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        finish = new boolean[R];
        for (int y = 0; y < R; y++) {
            map[y] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (!visited[i][0]) {
                visited[i][0] = true;
                makePipe(i, 0, i);
            }
        }
        System.out.println(answer);
    }
    static void makePipe(int pastY, int pastX, int startY) {
        if (finish[startY]) return;
        //System.out.println(pastY + ", " + pastX + " -> " + startY);
        if (pastX == C - 1) {
            //System.out.println("도착 : " + startY);
            finish[startY] = true;
            answer++;
            if (startY == R - 1) {
                return;
            }
            //System.out.println(startY + " -> " + answer);
            if (startY != R-1 && !visited[startY+1][0]) {
                visited[startY+1][0] = true;
                makePipe(startY + 1, 0, startY + 1);
            }
            return;
        }

        if (0 < pastY && map[pastY - 1][pastX + 1] == '.' && !visited[pastY - 1][pastX + 1]) {
            visited[pastY - 1][pastX + 1] = true;
            makePipe(pastY - 1, pastX + 1, startY);
//            if (!finish[startY])
//                visited[pastY - 1][pastX + 1] = false;
        }
        if (!finish[startY] && map[pastY][pastX + 1] == '.' && !visited[pastY][pastX + 1]) {
            visited[pastY][pastX + 1] = true;
            makePipe(pastY, pastX + 1, startY);
//            if (!finish[startY])
//                visited[pastY][pastX + 1] = false;
        }
        if (!finish[startY] &&pastY < R - 1 && map[pastY + 1][pastX + 1] == '.' && !visited[pastY + 1][pastX + 1]) {
            visited[pastY + 1][pastX + 1] = true;
            makePipe(pastY + 1, pastX + 1, startY);
//            if (!finish[startY])
//                visited[pastY+1][pastX + 1] = false;
        }
    }
}
