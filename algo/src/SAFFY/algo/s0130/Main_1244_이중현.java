package SAFFY.algo.s0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_이중현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sCnt = Integer.parseInt(br.readLine());
        int[] sw = new int[sCnt+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < sCnt+1; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }
        int pCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < pCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            // 남자일 경우
            if (s == 1) {
                for(int ch = idx; ch < sCnt+1; ch += idx) {
                    sw[ch] = sw[ch] == 1 ? 0 : 1;
                }
            // 여자일 경우
            }else {
                int pre = idx-1;
                int gap = 3;
                while (true) {
                    if ((1 <= pre && pre+gap-1 < sCnt+1) && sw[pre] == sw[pre + gap-1]) {
                        pre--;
                        gap += 2;
                    }else {
                        pre++;
                        gap -= 2;
                        break;
                    }
                }
                for(int k = 0; k < gap; k++) {
                    sw[pre+k] = sw[pre+k] == 0 ? 1 : 0;
                }
            }
        }
        int cnt = 1;
        for(int i = 1; i < sCnt+1; i++) {
            System.out.print(sw[i] + " ");
            if (cnt == 20) {
                cnt = 0;
                System.out.println();
            }
            cnt++;
        }
    }
}
