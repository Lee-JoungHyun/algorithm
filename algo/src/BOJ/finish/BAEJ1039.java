package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEJ1039 {
    public static int getPostCnt(int length, int k) {
        int answer = 0;
        for (int i=length-1; i>0; i--)
            answer += i;
        return (int)Math.pow(answer, k-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N은 6자리 수
        int K = Integer.parseInt(st.nextToken()); // K는 10번 이하
        int length = String.valueOf(N).length();
        int postCnt = getPostCnt(length, K);
        //System.out.println(length + ", " + K + ", " + postCnt);
        // BFS 로? -> 완탐 1회당 결국 모든 K회차를 찾아야 함! -> queue 에 (N, cnt) 를 두어 cnt == K 면 max 초기화, 아니면 queue에 넣기
        int max = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int cnt = 0;
        while (queue.size() != 0) {
            int tmp = queue.poll();
            String nStr = String.valueOf(tmp);
            if (nStr.length() != length)
                nStr = "0" + nStr;
            for (int i = 0; i < nStr.length()-1; i++) {
                for (int j = i+1; j < nStr.length(); j++) {
                    String nxtStr = nStr.substring(0, i) + nStr.charAt(j) + nStr.substring(i+1, j) + nStr.charAt(i) + nStr.substring(j+1, nStr.length());
                    int nxtN = Integer.parseInt(nxtStr);
                    //System.out.println(nxtN + ", " + (cnt+1));
                    if(++cnt >= postCnt) {
                        if (nxtN > max && String.valueOf(nxtN).length() == length)
                            max = nxtN;
                    }else {
                        queue.add(nxtN);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
