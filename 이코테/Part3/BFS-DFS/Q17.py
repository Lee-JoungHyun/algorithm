import sys
input = sys.stdin.readline

N, K = map(int, input().split())
plate = [[0 for j in range(N)] for i in range(N)]
virus = [[] for j in range(K+1)]
for i in range(N):
    b = input().strip()
    a = b.replace(" ", "")
    for j in range(N):
        plate[i][j] = int(a[j])
        if not a[j] == '0':
            virus[int(a[j])].append([j, i])
S, X, Y = map(int, input().split())

for _ in range(S): # S 동안 진행
    for i in range(1, len(virus)): # 바이러스 종류 낮은 순으로 진행
        tmp = []
        for v in virus[i]: # 해당 바이러스의 모든 것 전염
            dir = {0: [1, 0], 1: [0, 1], 2: [-1, 0], 3: [0, -1]}
            for j in range(4):
                nxt = [v[0] + dir[j][0], v[1] + dir[j][1]]
                if nxt[0] >= 0 and nxt[0] < N and nxt[1] >= 0 and nxt[1] < N and plate[nxt[1]][nxt[0]] == 0:
                    #print("전염 ", i, [nxt[1], nxt[0]])
                    plate[nxt[1]][nxt[0]] = i
                    tmp.append([nxt[0], nxt[1]])
        virus[i].clear()
        virus[i] = tmp[:]
        tmp.clear()

print(plate[X-1][Y-1])
