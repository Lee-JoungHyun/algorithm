package SAFFY.algo.s0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_9229_이중현 {
    static int N, M, snacks[], pre, post, answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            answer = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snacks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snacks);
            pre = 0;
            post = N-1;

            while (pre < post) {
                //System.out.println(pre + ", " + post);
                if (snacks[pre] + snacks[post] > M) post--;
                else {
                    answer = Math.max(answer, snacks[pre] + snacks[post]);
                    pre++;
                }

            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
