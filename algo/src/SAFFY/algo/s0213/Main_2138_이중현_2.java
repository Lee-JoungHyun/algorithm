package SAFFY.algo.s0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_이중현_2 {
    static int answer, N;
    static char[] target, start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        answer = go(start, 0);
        //1. 맨 앞누르기 추가
        start[0] = start[0] == '0' ? '1' : '0';
        start[1] = start[1] == '0' ? '1' : '0';
        answer = Math.min(answer, go(start, 1));
        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);

    }
    static int go(char[] st, int answer) {
        char[] tmp = Arrays.copyOf(st, st.length);
        for(int i = 1; i < N-1; i++) {
            if (tmp[i-1] != target[i-1]) {
                answer++;
                tmp[i-1] = tmp[i-1] == '0' ? '1' : '0';
                tmp[i] = tmp[i] == '0' ? '1' : '0';
                tmp[i+1] = tmp[i+1] == '0' ? '1' : '0';
            }
        }
        if (tmp[N-1] != target[N-1]) {
            answer++;
            tmp[N-1] = tmp[N-1] == '0' ? '1' : '0';
            tmp[N-2] = tmp[N-2] == '0' ? '1' : '0';
        }
        //System.out.println("tmp: " + Arrays.toString(tmp));
        for (int i = 0; i < N; i++)
            if (tmp[i] != target[i]) {
                return Integer.MAX_VALUE;
            }
        return answer;

    }
}
