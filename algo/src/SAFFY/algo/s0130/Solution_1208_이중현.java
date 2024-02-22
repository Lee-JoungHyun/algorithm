package SAFFY.algo.s0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt;
        int[] arr = new int[100];
        for(int t = 1; t < 11; t++) {
            cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < cnt; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);
            System.out.println("#" + t + " " + (arr[99]-arr[0]));
        }
    }
}
