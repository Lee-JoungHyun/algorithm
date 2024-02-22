package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1525 {
    public static class Graph {
        HashSet<String> visited;
        String answer = "123456780";
        int depth = 1;
        Graph() {
            this.visited = new HashSet<>();
        }
        public int BFS(String now) {
            if (now.equals(answer)) return 0;
            int[] move = {-3, 3, -1, 1}; // 상 하 좌 우
            // BFS 시작
            Queue<String> queue = new LinkedList<>();
            queue.add(now);
            //System.out.println(now);
            while (queue.size() != 0) {

                int qSize = queue.size();
                //System.out.println(this.depth);
                for (int d = 0; d < qSize; d++) {
                    String status = queue.poll();
                    visited.add(status);
                    //1. '0'의 인덱스 찾기
                    int zero = status.indexOf('0');
                    for (int i = 0; i < 4; i++) {
                        //2. 돌아다니며 내가 갈 수 있는지 확인하기
                        if (0 <= zero + move[i] && zero + move[i] < status.length()) {
                            //3. 문자열 생성하기
                            int pref;
                            int postf;
                            if (zero > zero + move[i]) {
                                pref = zero + move[i];
                                postf = zero;
                            } else {
                                pref = zero;
                                postf = zero + move[i];
                            }
                            String nxt = status.substring(0, pref) + status.charAt(postf) + status.substring(pref + 1, postf) + status.charAt(pref) + status.substring(postf + 1);
                            System.out.println(nxt);
                            //4. 정답인지 확인
                            if (nxt.equals(answer)) {
                                queue.clear();
                                return this.depth;
                            }
                            //5. visited에 있는지 확인하기
                            if (!visited.contains(nxt)) {
                                visited.add(nxt);
                                queue.add(nxt);
                            }
                            //6. 없다면 끝!!!!
                        }
                    }
                }
                depth++;
            }
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> visited = new HashSet<String>();
        String now = "";
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                now += st.nextToken();
            }
        }
        Graph t = new Graph();
        System.out.println(t.BFS(now));
        

    }
}
