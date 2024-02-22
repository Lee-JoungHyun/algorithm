package SAFFY.algo.s0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_이중현 {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2))
                    return 1;
                else if (Math.abs(o1) < Math.abs(o2))
                    return -1;
                else {
                    if (o1 > o2)
                        return 1;
                    else
                        return -1;
                }
            }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (pq.size() == 0) sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
            }else{
                pq.offer(tmp);
            }
        }
        System.out.println(sb);
    }
}
