package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N, M, answer[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        makePer(0);
        System.out.println(sb);
    }
    static void makePer(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            answer[cnt] = i;
            makePer(cnt + 1);
        }
    }
}
