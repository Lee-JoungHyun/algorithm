package SAFFY.algo.s0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_이중현 {
    static Queue<Integer> trucks;
    static Queue<Integer> bridge;
    static int N, W, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trucks = new LinkedList<>();
        bridge = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int time = 1;

        int weight = trucks.peek();
        bridge.add(trucks.poll());

        while ((!bridge.isEmpty() && !trucks.isEmpty()) || weight != 0) {
            if(bridge.size() >= L) {
                weight -= bridge.poll();
            }
            if (trucks.isEmpty() || weight + trucks.peek() > W) {
                bridge.add(0);
            }
            else {
                weight += trucks.peek();
                bridge.add(trucks.poll());
            }
            time++;
        }
        System.out.println(time);

    }
}

