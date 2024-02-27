package SAFFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class asdf {
    static int N, c, k, d, arr[];
    static int[] visit = new int[3001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int start = 0;
        int end = k;
        int answer = 1;

        for (int i = 0; i < end; i++) {
            if (visit[arr[i]] == 0) {
                cnt++;
            }
            visit[arr[i]]++;
        }
        visit[c] += 1;
        // 전에 C가 있었음 = cnt에 반영이 되어있음
        answer = visit[c] > 1 ? cnt : ++cnt;
        //System.out.println("0, 4 -> " + answer);
        while (start <= N-1) {

            if (--visit[arr[start]] == 0) {
                cnt--;
            }
            end++;
            if (visit[arr[(end - 1) % N]] == 0) {
                cnt++;
            }
            visit[arr[(end - 1) % N]]++;
            start++;

            answer = Math.max(answer, cnt);
            //System.out.println(start + ", " + end + " -> " + answer + "-" + cnt);
            if (answer == k+1)
                break;
        }
        System.out.println(answer);
    }
}