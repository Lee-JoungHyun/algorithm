package SAFFY.algo.s0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17478_이중현 {
    public static String pre = "____";
    public static void sol(int target, int now) {
        String tmp = "";
        for(int i = 0; i < now; i++) tmp += pre;
        System.out.println(tmp + "\"재귀함수가 뭔가요?\"");
        if (target == now) {
            System.out.println(tmp + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }else{
            System.out.println(tmp + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(tmp + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(tmp + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            sol(target, now+1);
        }

        System.out.println(tmp + "라고 답변하였지.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        sol(N, 0);
    }
}
