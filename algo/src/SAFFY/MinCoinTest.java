package SAFFY;

import java.util.Arrays;
import java.util.Scanner;

// 화폐단위 1, 4, 6
public class MinCoinTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N+1];

        D[0] = 0; // 점화식으로 값 X 초기화
        for (int i = 1; i <= N; i++) {
            D[i] = D[i-1] + 1; // 1원 사용 경우 임시 최적해
            if (i >= 4) D[i] = Math.min(D[i], D[i-4] + 1);
            if (i >= 6) D[i] = Math.min(D[i], D[i-6] + 1);
        }
        System.out.println(Arrays.toString(D));
        System.out.println(D[N]);
    }
}
