package SAFFY.algo.s0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_30892_이중현 {
    static int K, N;
    static long T;
    static int[] sharks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        sharks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sharks);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (sharks[i] < T) {
                stack.push(sharks[i]);
            }else{
                queue.add(sharks[i]);
            }
        }

        for (int i = 0; i < K; i++) {
            if(stack.isEmpty()) break;
            T += stack.pop();

            while (!queue.isEmpty() && queue.peek() < T) {
                //System.out.println(queue.peek() + ", " + T);
                stack.add(queue.poll());
            }

            //System.out.println(T);
        }




        System.out.println(T);
    }

}
