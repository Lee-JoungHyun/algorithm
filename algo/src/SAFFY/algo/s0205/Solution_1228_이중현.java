package SAFFY.algo.s0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_이중현 {
    static LinkedList<Integer> ll;
    static int N1, N2, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int tc = 1; tc < 11; tc++) {
            ll = new LinkedList<>();
            N1 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N1; i++) {
                ll.add(Integer.parseInt(st.nextToken()));
            }
            N2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N2; i++) {
                st.nextToken();
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                for(int j = 0; j < y; j++) {
                    ll.add(x + j, Integer.parseInt(st.nextToken()));
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(ll.get(i) + " ");
            }
            System.out.println();
        }
    }
}
