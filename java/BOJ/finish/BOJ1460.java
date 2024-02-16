package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1460 {
    static int N, M, X, Y, L, F, map[][], answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());

            for (int y = Y; y < Y+L; y++) {
                for (int x = X; x < X+L; x++) {
                    map[y][x] = F;
                }
            }
        }
         //입력 끝

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        int start = 1;
        int end = N;
        int mid = 0;
        while (start <= end) {
            mid = (start + end)/2;
            //System.out.println(start + ", " + end + " - " + mid + ": " + nCheck(mid));
            if (nCheck(mid)) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println((int)Math.pow((start + end)/2, 2));
    }
    // 밭의 사이즈를 줄때 가능한지 확인
    static boolean nCheck(int size) {
        HashSet<Integer> hs = new HashSet<Integer>();
        boolean flag;
        for(int y = 0; y < N-size+1; y++) {
            for (int x = 0; x < N-size+1; x++) {
                // 가능한 프레임
                flag = true;
                for (int i = 0; i < size * size; i++) {
                    int tmp = map[y+i/size][x+i%size];
                    hs.add(tmp);
                    if (tmp == 0 || hs.size() > 2) {
                        flag = false;
                        break;
                    }
                }
                hs.clear();
                if (flag) return true;
            }
        }
        return false;
    }

}
