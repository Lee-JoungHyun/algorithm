package SAFFY.algo.s0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1233_이중현 {
    static String[] nodeInput;
    static int N;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc < 11; tc++) {
            N = Integer.parseInt(br.readLine());
            flag = true;
            for (int i = 0; i < N; i++) {
                nodeInput = br.readLine().split(" ");
                //System.out.println(Arrays.toString(nodeInput));
                if (nodeInput.length == 2 && !Character.isDigit(nodeInput[1].charAt(0))) {
                    flag = false;
                }
            }
            if (flag) System.out.println("#" + tc + " 1");
            else System.out.println("#" + tc + " 0");
        }

    }

}
