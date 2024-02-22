package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1062 {
    // 등장한 알파벳을 저장시킴 (순서대로 비트)
    static HashMap<Character, Integer> alpha;
    static int alphaIdx;
    // 문자열 인덱스 기준으로 포함하는 알파벳을 비트로 처리해 | 연산!
    static int[] strs;
    static char[] tmp;
    static int N, K, alphaCnt, answer;
    // a, n, t, i, c
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;
        alphaIdx = 1;
        strs = new int[N];
        alpha = new HashMap<>();
        int alphaBit = 0;
        // antic 를 제외한 나머지 알파벳 비트마스킹, String 도 비트마스킹 처리해서 | 연산
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().toCharArray();
            for(int j = 0; j < tmp.length; j++) {
                if(tmp[j] != 'a' && tmp[j] != 'n' && tmp[j] != 't' && tmp[j] != 'i' && tmp[j] != 'c') {
                    if (!alpha.containsKey(tmp[j])) {
                        //System.out.print(tmp[j] + " ");
                        int asdf = 1<<alphaBit++;
                        alpha.put(tmp[j], asdf);
                    }
                    strs[i] = strs[i] | alpha.get(tmp[j]);
                }
                //System.out.println();
            }
        }
        System.out.println(Arrays.toString(strs));
        // 예외 처리
        if (K < 5) {
            System.out.println(0);
            return;
        }
        // 진행 -> 입력받는 알파벳 중에 antic를 제외한 것들중 K-5개를 뽑기
        alphaCnt = alpha.size();

        makeKs(0, 0, 0);
        System.out.println(answer);
    }
    static int hi = 0;
    static void makeKs(int cnt, int start,int compInt) {
        if (cnt == K-5) {
            hi++;
            calc(compInt);
            return;
        }
        for (int i = start; i < alphaCnt; i++) {
            int nxt = compInt + 1<<i;
            makeKs(cnt+1, i+1, nxt);
        }
    }
    static void calc(int value) {
        int tmp3 = 0;
        for (int i = 0; i < strs.length; i++) {
            //System.out.println(strs[i] + " - " + value);
            if ((strs[i] & value) == strs[i]) {
                //System.out.println("match");
                tmp3++;
            }
        }
        if (answer < tmp3) answer = tmp3;
    }

}
