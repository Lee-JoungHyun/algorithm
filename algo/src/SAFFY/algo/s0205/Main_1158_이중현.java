package SAFFY.algo.s0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158_이중현 {
    static int N, K;
    static LinkedList<Integer> arr = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            arr.add(i);
        }
        System.out.print("<");
        int idx = 0;
        while (arr.size() != 1) {
            idx = idx + (K-1) > arr.size()-1 ? (idx + (K-1)) % arr.size() : idx + (K-1);
            System.out.print(arr.remove(idx) + ", ");
        }
        System.out.println(arr.pop() + ">");
    }
}
