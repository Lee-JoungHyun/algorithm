package SAFFY.algo.s0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fb = N/5;
        //System.out.println(fb);
        for (int i = fb; i>=0; i--) {
            //System.out.println(N + " - (" + i*5 + ") % " + "3 = " + ((N - i*5) % 3));
            if ((N - i*5) % 3 == 0) {
                System.out.println(i + (N - i * 5) / 3);
                return;
            }
        }
        System.out.println(-1);

    }
}
