package BOJ.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236 {
    // 우선순위 큐 사용 폐기
    static int bsharkSize = 2, nowY, nowX;
    static class Shark implements Comparable<Shark>{
        public int y, x, size;

        public Shark(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            // 둘다 먹을 수 있다면
            if (this.size < bsharkSize && o.size < bsharkSize) {
                // 거리순
                if (calcDis(this.y, this.x) != calcDis(o.y, o.x)) {
                    return calcDis(this.y, this.x) - calcDis(o.y, o.x);
                }

                // 거리가 같으면
                else {
                    if (this.y != o.y)
                        return this.y - o.y;
                    else
                        return this.x - o.x;
                }
            }
            else if (this.size < bsharkSize)
                return -1;
            else if (o.size < bsharkSize)
                return 1;
            else
                return 0;

        }
        public boolean canEat(int x) {
            if (x > this.size)
                return true;
            else
                return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Shark> oldsharks = new PriorityQueue<>();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (0 < tmp && tmp < 9)
                    oldsharks.add(new Shark(y, x, tmp));
                else if (tmp == 9) {
                    nowY = y;
                    nowX = x;
                }
            }
        }
        PriorityQueue<Shark> newsharks = new PriorityQueue<>();

    }
    static int calcDis(int y, int x) {
        return Math.abs(y - nowY) + Math.abs(x - nowX);
    }
}
