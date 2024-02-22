package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] com = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) com[i] = Integer.parseInt(st.nextToken());
        int[] answer = Arrays.stream(com).sorted().toArray();
        if (Arrays.equals(com, answer)) {
            System.out.println(0);
            return;
        }
        HashSet<String> hs = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        int depth = 1;
        queue.add(com);
        while (queue.size() != 0) {
            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                int[] now = queue.poll();
                //System.out.println(Arrays.toString(now));
                hs.add(Arrays.toString(now));
                // 다음 갈 수 있는 애들 찾기
                for(int j = 0; j <= N-K; j++) { // j는 바뀔 위치의 시작점
                    int[] nxtArray = new int[N];
                    for(int k = 0; k < N; k++) { // k는 들어갈 위치
                        if(j <= k && k < j+K) {
                            nxtArray[k] = now[K+j-1-(k-j)];
                        }
                        else {
                            nxtArray[k] = now[k];
                        }
                    }
                    if (hs.contains(Arrays.toString(nxtArray))) continue;
                    else if (Arrays.equals(answer, nxtArray)) {
                        System.out.println(depth);
                        return;
                    }
                    else {
                        hs.add(Arrays.toString(nxtArray));
                        queue.add(nxtArray);
                    }
                }
            }
            depth++;
        }
        System.out.println(-1);
    }
}
