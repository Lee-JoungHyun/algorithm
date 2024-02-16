package SAFFY.algo.s0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_1218_이중현 {
    // ( [ { < 순서
    static Stack<Character> g1;
    static int length;
    static char[] tmpStr;
    static boolean flag;
    static int gap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g1 = new Stack<>();
        for (int tc = 1; tc < 11; tc++) {
            g1.clear();
            flag = true;
            length = Integer.parseInt(br.readLine());
            tmpStr = new char[length];
            tmpStr = br.readLine().toCharArray();
            for (int i = 0; i < length; i++) {
                if(tmpStr[i] == '(' || tmpStr[i] == '[' || tmpStr[i] == '{' || tmpStr[i] == '<')
                    g1.add(tmpStr[i]);
                else {
                    int gap = 2;
                    if (tmpStr[i] == ')') gap = 1;
                    //System.out.println(g1.peek() + " - " + tmpStr[i]);
                    if ((int)g1.pop() != (int)tmpStr[i]-gap) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && g1.isEmpty())
                System.out.println("#" + tc + " " + 1);
            else
                System.out.println("#" + tc + " " + 0);
        }
    }
}
