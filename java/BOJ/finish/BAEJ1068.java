package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEJ1068 {
    static class Tree {
        int N;
        int delLeafCnt = 0;
        LinkedList<Integer>[] map;
        public Tree(int n) {
            this.N = n;
            this.map = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                map[i] = new LinkedList<>();
            }
        }
        public void addChild(int parent, int child) {
            map[parent].add(child);
        }
        public int getLeafCnt() {
            int leafCnt = 0;
            for (int i = 0; i < N; i++) {
                if (map[i].size() == 0) leafCnt++;
            }
            return leafCnt;
        }
        public int delLeafCnt(int pozDel) {
            startDFS(pozDel);
            return this.getLeafCnt();
        }
        public int getChildCnt(int parent) {
            return map[parent].size();
        }
        public void startDFS(int del) {
            if (map[del].size() == 0) {
                map[del].add(-1);
                return;
            }
            else {
                for (int i = 0; i < map[del].size(); i++) {
                    startDFS(map[del].get(i));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Tree tmp = new Tree(N);
        int[] parents = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            // i는 자식, st.next가 부모
            int parent = Integer.parseInt(st.nextToken());
            parents[i] = parent;
            if (parent != -1) {
                tmp.addChild(parent, i);
            }
        }
        st = new StringTokenizer(br.readLine());
        int del = Integer.parseInt(st.nextToken());
        // -> DFS로 del 하위 리프노드 순자 세기
        // -> 형제 노드가 있는지 알아야 함;;
        int answer = tmp.delLeafCnt(del);
        if (parents[del] == -1) System.out.println(0);
        else {
            if (tmp.getChildCnt(parents[del]) == 1) // 형제 노드가 없다면
                System.out.println(answer + 1);
            else
                System.out.println(answer);
        }
    }
}
