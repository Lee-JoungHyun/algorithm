import sys
input = sys.stdin.readline
INF = int(1e9) # 무한대 값 초기화
# 1. 노드 수, 간선 수 받기
nodeCnt, edgeCnt = map(int, input().split())
# 2. 시작 노드 번호 받기
start = int(input())
# 3. 각 노드와 연결된 노드 정보 받는 리스트 생성
graph = [[] for i in range(nodeCnt + 1)]
# 4. 방문한 적 있는지 체크하는 목적의 리스트 만들기
visited = [False] * (nodeCnt + 1)
# 5. 최단거리 테이블 무한으로 초기화
distance = [INF] * (nodeCnt + 1)
# 6. 간선 정보 입력받기 x -> y 비용이 d / graph[출발지(x)] = (목적지(y), 거리(d)) -> graph[x][0] = y, graph[x][1] = d
for _ in range(edgeCnt):
    x, y, d = map(int, input().split())
    graph[x].append((y, d))
# 7. 방문하지 않은 노드 중 가장 최단거리가 짧은 노드 번호 반환
def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1, nodeCnt + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index
# 8. 다익스트라 함수
def dijkstra(start):
    # 시작 노드 초기화
    distance[start] = 0
    visited[start] = True
    for i in graph[start]: # 시작 노드와 연결된 것들 거리 초기화
        distance[i[0]] = i[1]
    # 시작 노드를 제외한 nodeCnt-1개 노드에 대한 반복
    for i in range(nodeCnt-1):
        # 현재 거리가 가장 짧은 노드 꺼내 방문처리
        nowShort = get_smallest_node()
        visited[nowShort] = True
        # 현재 노드와 연결된 다른 노드 확인
        for j in graph[nowShort]:
            cost = distance[nowShort] + j[1]
            # 현재 노드 거쳐 다른 노드 가는게 짧은 경우 변경
            if cost < distance[j[0]]:
                distance[j[0]] = cost
# 9. 다익스트라 알고리즘 실행
dijkstra(start)
for i in range(1, nodeCnt+1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])