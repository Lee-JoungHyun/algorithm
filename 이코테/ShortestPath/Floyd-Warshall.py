INF = int(1e9) # 무한대
# 1. 노드 수, 간선 수 입력받기
nodeCnt, edgeCnt = map(int, input().split())
# 2. 2차원 배열로 각각의 노드 사이 최솟값을 무한으로 초기화
graph = [[INF] * (nodeCnt + 1) for _ in range(nodeCnt + 1)]
# 3. 자기 자신으로 가는 경로는 0으로 초기화
for i in range(1, nodeCnt + 1):
    for j in range(1, nodeCnt + 1):
        if i == j:
            graph[i][j] = 0
# 4. 각 간선에 대한 정보를 입력받아 그 값 초기화
for _ in range(edgeCnt):
    x, y, d = map(int, input().split())
    graph[x][y] = d
# 5. 플로이드 워셜 알고리즘 -> 3중 반복문으로 (x -> y) 거리와 ((x -> Kn) + (Kn -> y)) 비교해 짧은 것으로 갱신!
for k in range(1, nodeCnt + 1):
    for x in range(1, nodeCnt + 1):
        for y in range(1, nodeCnt + 1):
            graph[x][y] = min(graph[x][y], graph[x][k] + graph[k][y])
# 6. 결과 출력!
for i in range(1, nodeCnt + 1):
    for j in range(1, nodeCnt + 1):
        if graph[i][i] == INF:
            print("INF", end=" ")
        else:
            print(graph[i][j], end=" ")
    print()

