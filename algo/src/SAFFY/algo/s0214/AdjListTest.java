package SAFFY.algo.s0214;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjListTest {
    static class Node {
        int to;
        Node next;
        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
        public Node(int to) {
            this.to = to;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        Node[] adjList = new Node[V]; // 인접되지 않은 상태로 초기화

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[to] = new Node(to, adjList[from]);
            adjList[from] = new Node(to, adjList[to]);
        }
        for (Node node : adjList) {
            System.out.println(node);
        }
    }
}
