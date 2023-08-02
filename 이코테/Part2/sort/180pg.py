N = int(input())
arr = []
for _ in range(N):
    a, b = input().split()
    arr.append([a, int(b)])

for i in sorted(arr, key=lambda x: x[1]):
    print(i[0], end=" ")
