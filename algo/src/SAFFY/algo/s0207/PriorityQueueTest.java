package SAFFY.algo.s0207;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        // 선언, 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 삽입
        pq.offer(5);
        pq.offer(1);
        pq.offer(2);
        // 제거
        System.out.println(pq.poll()); // 1
        System.out.println(pq.poll()); // 2
        System.out.println(pq.poll()); // 5
        // 정렬 조건 직접 구현하기!
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
