package SAFFY.algo.s0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2138_이중현 {
    static int N, qsize, depth;
    static char[] start, now, nxt, target, tmp;
    static Queue<char[]> queue;
    static HashSet<String> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = br.readLine().toCharArray();
        target = br.readLine().toCharArray();
        now = new char[N];
        nxt = new char[N];
        if (check(start)) {
            System.out.println(0);
            return;
        }
        hs = new HashSet<>();
        queue = new LinkedList<>();
        hs.add(start.toString());
        queue.add(start);
        // 항상 뭘하든 new 한 tmp에 받아 복사하기
        while (queue.size() != 0) {
            //if (depth == 1) break;
            qsize = queue.size();
            depth++;
            while (qsize-- > 0) {
                tmp = new char[N];
                tmp = queue.poll();
                for (int i = 0; i < N; i++)
                    now[i] = tmp[i];
                //1. 왼쪽 끝 스위치 누르기
                tmp = press0(now); // nxt변경됨
                if (check(tmp)) {
                    System.out.println(depth);
                    return;
                }
                if(!hs.contains(tmp.toString())) { // tmp 나온적 없으면
                    hs.add(tmp.toString());
                    nxt = new char[N];
                    for (int i = 0; i < N; i++) {
                        nxt[i] = tmp[i];
                    }
                    queue.add(nxt);
                }

                //2. 중간 스위치들 누르기
                for (int press = 1; press < N-1; press++) {
                    for (int i = 0; i < N; i++) {
                        if (i == press -1 || i == press || i == press + 1) {
                            tmp[i] = now[i] == '0' ? '1' : '0';
                        }
                        else {
                            tmp[i] = now[i];
                        }
                    }
                }
                if (check(tmp)) {
                    System.out.println(depth);
                    return;
                }
                if(!hs.contains(tmp.toString())) { // tmp 나온적 없으면
                    hs.add(tmp.toString());
                    nxt = new char[N];
                    for (int i = 0; i < N; i++) {
                        nxt[i] = tmp[i];
                    }
                    queue.add(nxt);
                }

                //3. 오른쪽 끝 스위치 누르기
                tmp = pressN(now);
                if(!hs.contains(tmp.toString())) { // tmp 나온적 없으면
                    hs.add(tmp.toString());
                    nxt = new char[N];
                    for (int i = 0; i < N; i++) {
                        nxt[i] = tmp[i];
                    }
                    queue.add(nxt);
                }
                if (check(tmp)) {
                    System.out.println(depth);
                    return;
                }

            }

        }
        System.out.println(-1);
    }
    static boolean check(char[] next) {
        for (int i = 0; i < N; i++) {
            if (next[i] != target[i])
                return false;
        }
        return true;
    }
    static char[] press0(char[] noww) {
        char[] nxt = new char[N];
        nxt[0] = (noww[0] == '1' ? '0' : '1');
        nxt[1] = (noww[1] == '1' ? '0' : '1');
        for (int i = 2; i < N; i++) {
            nxt[i] = noww[i];
        }
        return nxt;
    }
    static char[] pressN(char[] now) {
        char[] nxt = new char[N];
        for (int i = 0; i < N-2; i++) {
            nxt[i] = now[i];
        }
        nxt[N-2] = now[N-2] == '1' ? '0' : '1';
        nxt[N-1] = now[N-1] == '1' ? '0' : '1';
        return nxt;
    }

}
