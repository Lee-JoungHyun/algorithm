package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int R, N, tmp, vowel;

    static char[] code, alph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        alph = new char[N];
        code = new char[R];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            alph[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alph);

        vowel = (1) + (1<<'e' - 'a') + (1<<'i' - 'a') + (1<<'o' - 'a') + (1<<'u' - 'a');
        makePer(0, 0);
    }
    static void makePer(int cnt, int start) {
        if (cnt == R) {
            tmp = 0;
            for (int i = 0; i < R; i++) {
                //System.out.println(code[i] + ", " + (vowel & 1<<code[i] - 'a'));
                if ((vowel & 1<<code[i] - 'a') == 1<<code[i] - 'a')
                    tmp++;
            }
            if (0 < tmp && tmp <= R-2) {
                for(int i = 0; i < R; i++)
                    System.out.print(code[i]);
                System.out.println();
            }

            return;
        }
        for(int i = start; i < N; i++) {
            code[cnt] = alph[i];
            makePer(cnt+1, i+1);
        }
    }
}
