package SAFFY.algo.s0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_이중현 {
    static int N, R, C, answer;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = -1;
        // 우선 2^N을 4등분 -> 4등분 -> 4등분 해서 n,r이 어디에 포함하는지 찾아야함
        split(0, ((int) Math.pow(2, N))-1, 0, ((int) Math.pow(2, N))-1);

    }
    static void split(int startX, int endX, int startY, int endY) {
        //System.out.println(startX + ", " + endX + " - " + startY + ", " + endY + " : " + answer);
        if (!(startX <= C && C <= endX && startY <= R && R <= endY)) {
            answer += (endX - startX + 1) * (endY - startY + 1);
            return;
        }
        //System.out.println("dd");
        if (endX - startX == 1) {
            if (startX == C && startY == R) {
                System.out.println(answer+1);
            }
            else if (endX == C && startY == R) {
                System.out.println(answer+2);
            }
            else if (startX == C && endY == R) {
                System.out.println(answer+3);
            }
            else if (endX == C && endY == R) {
                System.out.println(answer+4);
            }
            return;
        }
        split(startX, (startX+endX)/2, startY, (startY+endY)/2); // 0
        split((startX+endX)/2+1, endX, startY, (startY+endY)/2); // 1
        split(startX, (startX+endX)/2, (startY+endY)/2+1, endY); // 2
        split((startX+endX)/2+1, endX, (startY+endY)/2+1, endY); // 3
    }

}
