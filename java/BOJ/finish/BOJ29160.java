package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ29160 {
    static PriorityQueue<Integer>[] pq = new PriorityQueue[12];
    static int N, K, pozi, value;
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 12; i++) {
            pq[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pozi = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            pq[pozi].offer(value);
        }
        for (int i = 0; i < K; i++) {
            m8();
        }
        int answer = 0;
        for (int i = 1; i < 12; i++) {
            if (!pq[i].isEmpty())
                answer += pq[i].poll();
        }
        System.out.println(answer);
    }
    static void m8() {
        for (int i = 1; i < 12; i++) {
            if (!pq[i].isEmpty()) {
                int tmp = pq[i].poll();
                pq[i].offer(tmp > 1 ? tmp - 1 : 0);
            }
        }
    }
}
