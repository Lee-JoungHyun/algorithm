package BOJ.finish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1043 {
    public static int answer;
    public static boolean[] partyFlag;
    public static boolean[] personFlag;
    public static LinkedList<Integer>[] persons;
    public static LinkedList<Integer>[] partys;

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람수, 파티수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        persons = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            persons[i] = new LinkedList<>();
        }
        partys = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            partys[i] = new LinkedList<>();
        }
        partyFlag = new boolean[M];
        personFlag = new boolean[N];

        // 진지맨 처리
        st = new StringTokenizer(br.readLine());
        int gPCnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < gPCnt; i++) {
            personFlag[Integer.parseInt(st.nextToken())-1] = true;
        }

        // 파티 입력받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cPcnt = Integer.parseInt(st.nextToken());
            // 파티 참석 처리, i: 파티, cP: 사람
            for (int j = 0; j < cPcnt; j++) {
                int cP = Integer.parseInt(st.nextToken())-1;
                persons[cP].add(i);
                partys[i].add(cP);
                if(personFlag[cP]) partyFlag[i] = true;
            }
        }

        // partyFlag 로 DFS 시작
        for (int i = 0; i < M; i++) {
            //System.out.println(Arrays.toString(partyFlag));
            if (partyFlag[i]) {
                // 진실 대화 파티면 DFS로 퍼트리기
                DFS(i);
            }
        }
        for(boolean e : partyFlag)
            if (!e) answer++;
        System.out.println(answer);
    }
    public static void DFS(int i) {
        partyFlag[i] = true;
        Iterator<Integer> it = partys[i].listIterator();
        while (it.hasNext()) {
            int per = it.next();
            Iterator<Integer> it2 = persons[per].listIterator(); // 진실대화 해야하는 사람들
            while (it2.hasNext()) {
                int partyidx = it2.next();
                if (!partyFlag[partyidx])
                    DFS(partyidx);
            }
        }

    }
}
