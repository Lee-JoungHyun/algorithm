import sys
input = sys.stdin.readline
answer = []
T = int(input())
for i in range(T):

    N, M = map(int, input().split())
    t = input().replace(' ', '').replace('\n', '')
    gold = []
    cnt = 0
    tmp = []
    for g in t:
        tmp.append(int(g))
        cnt += 1

        if cnt >= M:
            gold.append(tmp)
            tmp = []
            cnt = 0

    dp = [[0 for j in range(M)] for i in range(N)]
    for i in range(N):
        dp[i][0] = gold[i][0]

    for j in range(1, M): # 가로
        dp[0][j] = max(dp[0][j-1], dp[1][j-1]) + gold[0][j]
        dp[N-1][j] = max(dp[N-1][j-1], dp[N-2][j-1]) + gold[N-1][j]
        for i in range(1, N-1): # 세로
            dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1]) + gold[i][j]

    tmp = []
    for i in range(N):
        tmp.append(dp[i][M-1])
    answer.append(max(tmp))

for i in answer:
    print(i)






