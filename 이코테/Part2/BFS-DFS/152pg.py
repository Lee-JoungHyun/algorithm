from collections import deque
N, M = map(int, input().split())
visited = [list(map(int, input().split())) for _ in range(N)]

my = [1, 1]
go = {0: [0, -1], 1: [1, 0], 2: [0, 1], 3: [-1, 0]} # 위부터 시계방향


def bfs(start):
    queue = deque([start])
    answer = 0

    while queue:
        v = queue.popleft()
        flag = False
        for i in range(4):
            way = go[i]
            nxt = [v[0] + way[0], v[1] + way[1]]
            if nxt[0] == M-1 and nxt[1] == N-1:
                print(answer)
                return
            elif nxt[0] < 0 or nxt[0] >= M or nxt[1] < 0 or nxt[1] >= N:
                pass
            else:
                if visited[nxt[1]][nxt[0]] == 1: #방문 안한 곳이면?
                    visited[nxt[1]][nxt[0]] = 3 # 방문 처리
                    queue.append(nxt)
                    flag = True
        if flag:
            answer += 1

bfs(my)

