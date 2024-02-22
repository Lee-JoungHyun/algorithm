package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ1003 {

    static LinkedList<int[]> FiboValue;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        FiboValue = new LinkedList<>();
        FiboValue.add(new int[]{1, 0});
        FiboValue.add(new int[]{0, 1});
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            }
            else if(N == 1) {
                sb.append(0).append(" ").append(1).append("\n");
            }
            else {
                if (FiboValue.size() < N) {
                    for (int i = FiboValue.size(); i < N; i++) {
                        FiboValue.add(new int[]{FiboValue.get(i - 1)[0] + FiboValue.get(i - 2)[0], FiboValue.get(i - 1)[1] + FiboValue.get(i - 2)[1]});
                    }
                }
                tmp = new int[]{FiboValue.get(N - 1)[0] + FiboValue.get(N - 2)[0], FiboValue.get(N - 1)[1] + FiboValue.get(N - 2)[1]};
                //sb.append(FiboValue.add(tmp));
                sb.append(tmp[0]).append(" ").append(tmp[1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
