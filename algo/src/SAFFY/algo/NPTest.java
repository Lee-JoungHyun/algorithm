package SAFFY.algo;

import java.util.Arrays;
import java.util.Scanner;

public class NPTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        // step0 : 정렬 오름차순
        Arrays.sort(input);

        do {
            // 순열 이용 처리 로직자리
            System.out.println(Arrays.toString(input));
        } while (np(input));

    }
    // 순열의 뒷쪽부터 작은 변화를 준다!!!!!
    public static boolean np(int[] p) { // 현 순열의 사전순 다음 순열 생성 (P: 현 순열)
        final int N = p.length;
        // step1: 교환 위치 찾기 (꼭대기를 찾으면 꼭대기 이전이 교환 위치)
        int i = N-1;
        while (i > 0 && p[i-1] >= p[i]) --i;// 나보다 앞인 놈이 크다 (오르막 형태이다)

        if (i == 0) return false; // 현 순열의 상태가 가장 큰 순열이므로 np 없음!

        // step2: 교환 위치 (i-1 <-> j) 인 값 뒤쪽부터 찾기 (큰값 중 최소값)
        int j = N-1;
        while (p[i-1] >= p[j]) --j;

        // step3: (i-1) 과 찾은 위치 j 교환
        swap(p, i-1, j);

        // step4: 꼭대기(i) 부터 맨 뒤까지 오름차순 정렬 만들기!
        int k = N-1;
        while (i < k) swap(p, i++, k--);

        return true;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
