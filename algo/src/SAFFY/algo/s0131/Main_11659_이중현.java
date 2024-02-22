package SAFFY.algo.s0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11659_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());
        int tmp = Integer.parseInt(st.nextToken());
        nums[0] = tmp;
        sum[0] = tmp;
        for(int i = 1; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());
            nums[i] = tmp;
            sum[i] = tmp + sum[i - 1];
        }
        int tmp1;
        int tmp2;
        int pre, post;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            tmp1 = Integer.parseInt(st.nextToken());
            tmp2 = Integer.parseInt(st.nextToken());
            pre = Math.min(tmp1, tmp2)-2;
            post = Math.max(tmp1, tmp2)-1;
            if (pre < 0)
                System.out.println(sum[post]);
            else
                System.out.println(sum[post] - sum[pre]);
        }

    }
}
