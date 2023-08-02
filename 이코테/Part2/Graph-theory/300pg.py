N, M = map(int, input().split()) # N = 집 수, M = 길 수
edge = []   # 노드, 노드, 유지비, 사이클 확인하기??
house = []  # 서로소 확인을 위한 리스트
for i in range(N+1):
    house.append(i)

def find_roothouse_renewel(house, x):
    if x == house[x]:
        return x
    else:
        house[x] = find_roothouse_renewel(house, house[x])
        return house[x]


def make_road(house,a, b):
    a_p = find_roothouse_renewel(house, a)
    b_p = find_roothouse_renewel(house, b)

    if a_p > b_p: # 작은것 이 부모로 합치기!!
        house[a_p] = b_p
    else:
        house[b_p] = a_p

    find_roothouse_renewel(house, a)
    find_roothouse_renewel(house, b)

def find_cycle(house ,a, b):
    a_p = find_roothouse_renewel(house, a)
    b_p = find_roothouse_renewel(house, b)

    if a_p == b_p:
        return True
    else:
        return False

for _ in range(M):
    a, b, c = map(int, input().split())
    edge.append((a, b, c))

edge.sort(key=lambda x:x[2])
cost = 0
maxcost = 0

for i in edge:
    if not (find_cycle(house, i[0], i[1])):
        make_road(house, i[0], i[1])
        cost += i[2]
        maxcost = i[2]


print(cost - maxcost)