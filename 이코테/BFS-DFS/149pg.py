from collections import deque

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
x = 0
y = 0

def bfs(x, y):
    # 현재 구멍이면, 방문 처리 후 상하좌우 재귀 실행
    if arr[x, y] == 0:
        arr[x, y] = 3
        bfs(x+1, y)
        bfs(x-1, y)
        bfs(x, y+1)
        bfs(x, y-1)
        return True
    else:
        return False


result = 0
for i in range(N):
    for j in range(M):
        if bfs(i,j):
            result += 1

print(result)
