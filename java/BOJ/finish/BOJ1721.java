package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class box {
    int Num, top, right, bottom, left;
    public box(int num, int top, int right, int bottom, int left) {
        Num = num;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }
}
public class BOJ1721 {
    static box[] boxs;
    static int N, poz[][], cnt[][];
    static int pX;
    static int pY;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        poz = new int[N][N];
        cnt = new int[N][N];
        boxs = new box[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            boxs[i] = new box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

    }
    public static void replace(int cnt) {

    }
}
