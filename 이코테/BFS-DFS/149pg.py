from collections import deque

M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]
x = 0
y = 0

def bfs(x, y):
    # 현재 구멍이면, 방문 처리 후 상하좌우 재귀 실행
    if x > N-1 or x < 0 or y > M-1 or y < 0:
        return False
    elif arr[y][x] == 0:
        print(x, y)
        arr[y][x] = 3
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
        if bfs(i, j):
            result += 1

print(result)
