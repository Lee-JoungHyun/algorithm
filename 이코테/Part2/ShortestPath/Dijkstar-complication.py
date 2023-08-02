import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한대 값 초기화
# 1. 노드 수, 간선 수 받기
nodeCnt, edgeCnt = map(int, input().split())
# 2. 시작 노드 번호 받기
start = int(input())
# 3. 각 노드와 연결된 노드 정보 받는 리스트 생성
graph = [[] for i in range(nodeCnt + 1)]
# 4. 최단거리 테이블 무한으로 초기화
distance = [INF] * (nodeCnt + 1)

# 다익스트라 함수
def dijkstra(start):
    q = []
    # 시작노드로 가기위한 최단경로는 0으로 설정하여 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드 정보 꺼내기
        dist, nowShort = heapq.heappop(q)
        # 현재 노드가 방문한 적 있으면 무시 ?? -> 이미 방문 했으니
        if distance[nowShort] < dist:
            continue
        # 현재 노드와 연결된 다른 인접 노드 확인
        for i in graph[nowShort]:
            cost = dist + i[1]
            # 현재 노드를 거쳐 다른 노드로 이동하는게 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
# 다익스트라 알고리즘 실행
dijkstra(start)
for i in range(1, nodeCnt+1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])