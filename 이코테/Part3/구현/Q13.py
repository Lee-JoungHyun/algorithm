from itertools import combinations
def chickencnt(house, chicken):
    distence = 0
    tmp = []
    for home in house:
        tmp.clear()
        for ch in chicken:
            tmp.append(abs(home[0] - ch[0]) + abs(home[1] - ch[1]))
        distence += min(tmp)
    return distence


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
house = []
chicken = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append([j, i])
        elif arr[i][j] == 2:
            chicken.append([j, i])
answer = []
for step in list(combinations(chicken, M)):
    answer.append(chickencnt(house, step))
print(min(answer))





