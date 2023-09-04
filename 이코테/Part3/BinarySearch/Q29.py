import sys
input = sys.stdin.readline
N, C = map(int, input().split())
house = []
for _ in range(N):
    house.append(int(input()))
house.sort()
# gap 찾기
start = house[0]
end = house[N-1]

while (start > end):
    gap = (end + start) // 2
    