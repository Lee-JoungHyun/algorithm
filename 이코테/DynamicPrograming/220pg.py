N = int(input())
arr = list(map(int, input().split()))

answer = [0]*(N+1)
answer[1] = max(arr[0], arr[1])
for i in range(2, N):
    answer[i] = max(answer[i-1], answer[i-2] + arr[i])

print(answer[N-1])