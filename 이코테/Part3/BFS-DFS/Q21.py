import sys
import itertools
from collections import deque
input = sys.stdin.readline
N, L, R = map(int, input().split())
A = [[0 for j in range(N)] for i in range(N)]
visit = [[False for j in range(N)] for i in range(N)]

for r in range(N):
    num = list(map(int, input().split()))
    for c in range(N):
        A[r][c] = num[c]

def bfs(A, visit, start, N, L, R): #start = [세로, 가로]
    if visit[start[0]][start[1]]:
        return []
    tmp = []
    queue = deque([start])
    tmp.append(start)
    visit[start[0]][start[1]] = True
    dir = {0:[0, 1], 1:[0, -1], 2:[1, 0], 3:[-1, 0]}
    while queue:
        v = queue.popleft()
        for i in range(4):
            if 0 <= v[0] + dir[i][0] < N and 0 <= v[1] + dir[i][1] < N and L <= abs(A[v[0]][v[1]] - A[v[0]+dir[i][0]][v[1]+dir[i][1]]) <= R and not visit[v[0]+dir[i][0]][v[1]+dir[i][1]]:
                visit[v[0]+dir[i][0]][v[1]+dir[i][1]] = True
                queue.append([v[0]+dir[i][0], v[1]+dir[i][1]])
                tmp.append([v[0]+dir[i][0], v[1]+dir[i][1]])
    return tmp
cnt = 0
while(True):
    alliance = []
    for r in range(N):
        for c in range(N):
            start = [r, c]
            alliance.append(bfs(A, visit, start, N, L, R))
    show = list(itertools.chain.from_iterable(alliance))
    flag = True
    for ali in alliance:
        if not len(ali) == 1 and not len(ali) == 0:
            flag = False
    if flag:
        break

    sum = 0
    for ali in alliance:
        for i in ali:
            sum += A[i[0]][i[1]]
    for ali in alliance:
        for i in ali:
            A[i[0]][i[1]] = sum // len(ali)
    cnt += 1

print(cnt)









