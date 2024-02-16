package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEJ1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] matrix1 = new char[N][M];
        char[][] matrix2 = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            matrix1[i] = line.toCharArray();
        }
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            matrix2[i] = line.toCharArray();
        }
        if (N < 3 || M < 3)
            System.out.println(-1);
        else {
            int[] dx = {0, 0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = {0, 1, 1, 0, -1, -1, -1, 0, 1};

            int cnt = 0;
            while (true) {

                int changeX = 0;
                int changeY = 0;
                int changeP = 0;

                for (int y = 1; y < N - 1; y++) {
                    for (int x = 1; x < M - 1; x++) {
                        int myP = 0;
                        for (int d = 0; d < 9; d++)
                            if (matrix1[y + dy[d]][x + dx[d]] != matrix2[y + dy[d]][x + dx[d]])
                                myP++;
                        if (myP > changeP) {
                            changeX = x;
                            changeY = y;
                            changeP = myP;
                        }
                    }
                }
                //System.out.println(changeX + ", " + changeY);
                if (changeP == 0) {
                    break;
                }
                cnt++;
                for (int d = 0; d < 9; d++)
                    matrix1[changeY + dy[d]][changeX + dx[d]] = (matrix1[changeY + dy[d]][changeX + dx[d]] == '0' ? '1' : '0');
            }
            System.out.println(cnt);
        }
    }
}
