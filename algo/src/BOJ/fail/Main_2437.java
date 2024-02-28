package BOJ.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] chu = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chu[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(chu);

        int total = 1;
        for (int i = 0; i < N; i++) {
            if (chu[i] > total) {
                break;
            }
            else total += chu[i];
        }
        System.out.println(total);

    }
}
