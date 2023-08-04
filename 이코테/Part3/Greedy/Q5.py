N, M = map(int, input().split())
ball = list(map(int, input().split()))
print(N*(N-1)//2 - (N - len(set(ball))))

#12 분

