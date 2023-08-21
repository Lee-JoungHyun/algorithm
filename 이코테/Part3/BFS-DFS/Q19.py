import sys
input = sys.stdin.readline

N = int(input()) # 계산횟수 = N-1
num = list(map(int, input().split())) # 수들
oper = list(map(int, input().split())) # 덧셈, 뺄셈, 곱셈, 나눗셈 의 개수
answer = []

# 계산방법 value ? num[i]
def dfs(i, oper, value):
    if i >= N:
        global answer
        answer.append(value)
        return
    if oper[0] > 0:
        tmp = oper[:]
        tmp[0] = tmp[0] - 1
        dfs(i+1, tmp, value + num[i])
    if oper[1] > 0:
        tmp = oper[:]
        tmp[1] = tmp[1] - 1
        dfs(i+1, tmp, value - num[i])
    if oper[2] > 0:
        tmp = oper[:]
        tmp[2] = tmp[2] - 1
        dfs(i+1, tmp, value * num[i])
    if oper[3] > 0:
        tmp = oper[:]
        tmp[3] = tmp[3] - 1
        if value < 0:
            dfs(i+1, tmp, -(abs(value) // num[i]))
        else:
            dfs(i + 1, tmp, value // num[i])

dfs(1, oper, num[0])
print(max(answer))
print(min(answer))





