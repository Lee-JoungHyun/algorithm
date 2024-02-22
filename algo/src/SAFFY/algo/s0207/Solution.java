package SAFFY.algo.s0207;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.*;
import java.util.*;

import java.lang.*;
import java.util.*;

public class Solution{
    static int N;
    static boolean[] visited;
    static int[][] room;
    static int[][] order;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) { // testCase 개수
            N = Integer.parseInt(br.readLine()); // NN 방
            visited = new boolean[N*N+1];
            room = new int[N+1][N+1];
            order = new int[N*N+1][2];

            for (int i = 1; i <= N; i++) { // i번째 줄
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) { // j번째 방번호
                    int odNm = Integer.parseInt(st.nextToken()); // 방번호
                    room[i][j] = odNm;
                    order[odNm][0] = i; // 방번호의 i번째 줄
                    order[odNm][1] = j; // 방번호의 j번째 방
                }
            }

            int max = -1;
            int roomNum = 0;

            for(int i = 1; i<= N*N ; i++) { // 1번부터 N*N번까지 위치 확인
                int iN = order[i][0];
                int jN = order[i][1];

                if (visited[i] == false) {
                    int count = bfs(iN, jN, i, 0);
                    System.out.println("main: " + count);
                    if (count > max) {
                        max = count;
                        roomNum = i;
                    }
                }
            }
            System.out.println("#"+t+" "+roomNum+" "+max);
        }
    }

private static int bfs(int iN, int jN, int roomNum, int count) {
    count += 1;
//        System.out.println(iN + " " + jN + " " + roomNum);
//        System.out.println(count);
        visited[roomNum] = true;
        for (int i = 0; i < 4; i++) {
            int x = iN + dx[i];
            int y = jN + dy[i];
            if(x<1 || x> N || y<1 || y>N) { // room 바깥 범위면 넘어감
                continue;
            }else { // 이동가능한 범위면
                if(room[x][y] == roomNum+1) { // 이동할 수 있는 방이면
                    bfs(x,y,roomNum+1,count);
                }

            }
        }

        System.out.println("bfs: " + count);
        return count;
    }
}

