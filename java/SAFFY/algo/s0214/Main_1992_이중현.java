package SAFFY.algo.s0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_이중현 {
    static int N;
    static char map[][];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        split(0, 0, N);
        System.out.println(sb);

    }

    /** 재귀로 4등분하여 실행 */
    static void split(int startY, int startX, int size) {
        // 범위 내부가 모두 같으면 압축 (그 값을 sb에 추가)
        if (check(startY, startX, size)) {
            sb.append(map[startY][startX]);
        }
        // 범위 내부가 다르면 "("추가 - split(4방향) - ")"추가 를 재귀적으로 수행
        else {
            sb.append("(");
            split(startY, startX, size/2);
            split(startY, startX + size/2, size/2);
            split(startY + size/2, startX, size/2);
            split(startY + size/2, startX + size/2, size/2);
            sb.append(")");
        }
    }

    /** 범위 내 값이 모두 같은지 확인하는 함수: boolean */
    static boolean check(int startY, int startX, int size) {
        char tmp = map[startY][startX];
        for (int y = startY; y < startY + size; y++) {
            for (int x = startX; x < startX + size; x++) {
                if (map[y][x] != tmp)
                    return false;
            }
        }
        return true;
    }


}
