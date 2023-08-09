from collections import deque
import sys
input = sys.stdin.readline


def bfs(graph, start, visited, distence, K):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                distence[i] = distence[v] + 1
                visited[i] = True


N, M, K, X = map(int, input().split())
graph = [[] for j in range(N+1) ]
visited = [False for j in range(N+1)]
distence = [0 for j in range(N+1)]
for _ in range(M):
    start, end = map(int, input().split())
    graph[start].append(end)
bfs(graph, X, visited, distence, K)
flag = True
for i in range(1, N+1):
    if K == distence[i]:
        print(i)
        flag = False
if flag:
    print('-1')


