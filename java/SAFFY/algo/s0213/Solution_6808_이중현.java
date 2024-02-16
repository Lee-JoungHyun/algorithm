package SAFFY.algo.s0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_6808_이중현 {
    static int win, lose, p1[], p2[], per[];
    static boolean flag[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            HashSet<Integer> hs = new HashSet<>();
            p1 = new int[9];
            p2 = new int[9];
            per = new int[9];
            flag = new boolean[9];
            win = 0;
            lose = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                p1[i] = tmp;
                hs.add(tmp);
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if(!hs.contains(i))
                    p2[idx++] = i;
            }

            makePer(0);
            sb.append("#").append(tc).append(" ").append(lose).append(" ").append(win).append("\n");
            ///
        }
        System.out.println(sb);
    }
    static void makePer(int n) {
        if (n == 9) {
            check();
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!flag[i]) {
                flag[i] = true;
                per[n] = p2[i];
                makePer(n + 1);
                flag[i] = false;
            }
        }
    }
    static void check() {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < 9; i++) {
            if (p1[i] > per[i])
                num1 += p1[i] + per[i];
            else
                num2 += p1[i] + per[i];
        }
        if (num1 > num2) lose++;
        else if (num2 > num1) win++;
    }

}
