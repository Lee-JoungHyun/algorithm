import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
end = N-1
start = 0
while True:
    if start > end:
        print(-1)
        break
    if arr[(start + end) // 2] > (start + end) // 2: # 값이 인덱스보다 크다면 왼쪽으로
        end = (start + end) // 2 - 1
    elif arr[(start + end) // 2] < (start + end) // 2: # 값이 인덱스보다 작다면 오른쪽
        start = (start + end) // 2 + 1
    else:
        print((start + end) // 2)
        break