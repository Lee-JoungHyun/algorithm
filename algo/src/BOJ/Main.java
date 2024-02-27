package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<long[]> ms;
    static long N, y, x, py, px, answer1, answer2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ms = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        Long zeroX = -1L;
        Long upx = -1L;
        boolean upFlag = false; // down 시 up을 했으면 봉우리 생성!
        st = new StringTokenizer(br.readLine());
        px = Long.parseLong(st.nextToken());
        py = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());
            if (x == px && y * py < 0) { // 세로 이동, 부호 변화!
                if (y > py) { // up
                    upFlag = true;
                    upx = x;
                }else { // down
                    if(upFlag) {
                        upFlag = false;
                        ms.add(new long[] {(upx > x ? x : upx), (upx > x ? upx : x)});
                    }
                    else {
                        zeroX = x;
                    }
                }
            }
            px = x;
            py = y;
        }
        if (zeroX != -1) {
            ms.add(new long[] {Math.min(zeroX, upx), Math.max(zeroX, upx)});
        }
        ms.sort((o1, o2) -> Math.toIntExact(o2[1] - o1[1]));
        long now[];
        long minX = 10000000000L;
        // 가장 오른쪽은 항상 포함되지 않고, 가장 왼쪽의 것은 항상 포함하지 않음 -> 정렬되어서
        answer1 = 1;
        answer2 = 1;
        for (int m = 0; m < ms.size(); m++) {
            now = ms.get(m);
            // 포함되지 않는지 확인
            if (m > 0 && now[1] < minX) answer1++;

            // 포함하지 않는지 확인
            if (m < ms.size()-1 && now[0] > ms.get(m+1)[1]) answer2++;
            minX = Math.min(minX, now[0]);
        }
        System.out.println(answer1 + " " + answer2);
    }
}
