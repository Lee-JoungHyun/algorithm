package SAFFY.algo.s0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_이중현 {
    static int condi[], flag[], S, P, answer;
    static char str[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        answer = 0;
        str = br.readLine().toCharArray();
        condi = new int[4];
        flag = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            condi[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < P; i++) {
            setChar(str[i]);
        }
        check();
        for(int pre = 1, post = P; post < str.length; pre++, post++) {
            setChar(str[post]);
            popChar(str[pre-1]);
            check();
        }
        System.out.println(answer);
    }
    static void setChar(char tmp) {
        if(tmp == 'A') flag[0]++;
        else if(tmp == 'C') flag[1]++;
        else if(tmp == 'G') flag[2]++;
        else if(tmp == 'T') flag[3]++;
    }
    static void popChar(char tmp) {
        if(tmp == 'A') flag[0]--;
        else if(tmp == 'C') flag[1]--;
        else if(tmp == 'G') flag[2]--;
        else if(tmp == 'T') flag[3]--;
    }
    static void check() {
        for (int i = 0; i < 4; i++) {
            if (flag[i] < condi[i]) return;
        }
        answer++;
    }
}
