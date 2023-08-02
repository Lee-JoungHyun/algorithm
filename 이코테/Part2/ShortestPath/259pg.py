"""
import heapq
INF = int(1e9)
N, M = map(int, input().split()) # N = 노드 수, M = 간선 수
path = [[] for i in range(N + 1)]
# path의 형태는 0~N 까지 존재하는 배열에 해당 경로 존재시 옆으로 달아버리는 형태
for _ in range(M):
    a, b = map(int, input().split())
    path[a].append((b))
    path[b].append((a))
X, K = map(int, input().split()) # 1 -> K -> X
distance = [INF] * (N + 1)

def dijkstra(start):
    q = [] # 큐에는 (거리, 간선) 형태로 저장
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:  # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드 정보 꺼내기
        dist, nowShort = heapq.heappop(q)
        # 현재 노드가 방문한 적 있으면 무시 ?? -> 이미 방문 했으니 길이가 짧을 수 밖에;;
        if distance[nowShort] < dist:
            continue
        # 현재 노드와 연결된 다른 인접 노드 확인
        for i in path[nowShort]:
            cost = dist + 1
            # 현재 노드를 거쳐 다른 노드로 이동하는게 짧은 경우
            if cost < distance[i]:
                distance[i] = cost
                heapq.heappush(q, (cost, i))

dijkstra(1)
a1 = distance[K]
distance = [INF] * (N + 1)
dijkstra(K)
a2 = distance[X]

print(a1, a2)
"""
##
INF = int(1e9)
N, M = map(int, input().split()) # N = 노드 수, M = 간선 수
graph = [[INF] * (N + 1) for _ in range(N + 1)]
# 3. 자기 자신으로 가는 경로는 0으로 초기화
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j:
            graph[i][j] = 0
# 4. 각 간선에 대한 정보를 입력받아 그 값 초기화
for _ in range(M):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1
X, K = map(int, input().split())
# 5. 플로이드 워셜 알고리즘 -> 3중 반복문으로 (x -> y) 거리와 ((x -> Kn) + (Kn -> y)) 비교해 짧은 것으로 갱신!
for k in range(1, N + 1):
    for x in range(1, N + 1):
        for y in range(1, N + 1):
            graph[x][y] = min(graph[x][y], graph[x][k] + graph[k][y])

answer = graph[1][K] + graph[K][X]

if answer >= INF:
    print(-1)
else:
    print(answer)
