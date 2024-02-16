package SAFFY.algo.s0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1289_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            char[] tmp = br.readLine().toCharArray();
            int answer = 0;
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == '1') {
                    answer++;
                    for(int j = i; j < tmp.length; j++) {
                        tmp[j] = tmp[j] == '0' ? '1' : '0';
                    }
                }
            }
            System.out.println("#" + (tc+1) + " " + answer);
        }
    }
}
