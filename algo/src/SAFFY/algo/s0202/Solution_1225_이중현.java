package SAFFY.algo.s0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_이중현 {
    static Queue<Integer> pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        for (int tc = 1; tc < 11; tc++) {
            sb = new StringBuilder();
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            pw = new LinkedList<>();
            for(int i = 0; i < 8; i++) {
                pw.offer(Integer.parseInt(st.nextToken()));
            }
            int idx = 1;
            while (pw.peek() - idx > 0) {
                pw.offer(pw.poll()-idx);
                idx = idx == 5 ? 1 : idx+1;
            }
            pw.poll();
            pw.offer(0);
            System.out.print("#" + tc + " ");
            for(int i = 0; i < 8; i++) {
                sb.append(pw.poll() + " ");
            }
            System.out.println(sb);
        }
    }
}
