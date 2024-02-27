package SAFFY.algo.s0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_이중현 {
    static int N, D, K, C, tmp, answer, belt[], have[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        belt = new int[N];
        have = new int[D + 1];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            belt[i] = tmp;
            // 초기 윈도우
            if (i < K) {
                if (have[tmp] == 0) {
                    cnt++;
                }
                have[tmp]++;
            }
        }
        // 초기 윈도우 값
        if (have[C] == 0)
            answer = cnt + 1;
        else
            answer = cnt;

        for (int i = 1; i < N; i++) {
            // i-1 빼주고
            if (have[belt[i-1]] == 1) {
                cnt--;
            }
            have[belt[i-1]]--;

            // (i+K-1)%N 넣어주기
            if (have[belt[(i+K-1)%N]] == 0) {
                cnt++;
            }
            have[belt[(i+K-1)%N]]++;

            if (have[C] == 0) {
                answer = Math.max(answer, (cnt + 1));
                //System.out.println(i + ": " + (cnt + 1));
            }
            else {
                answer = Math.max(answer, cnt);
                //System.out.println(i + ": " + cnt);
            }
            // Max값 이미 나옴
            if (answer == K+1)
                break;
        }
        System.out.println(answer);
    }

}
