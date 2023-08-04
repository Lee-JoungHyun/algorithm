N = int(input())
coin = list(map(int, input().split()))
coin.sort()
answer = 1
for i in coin:
    if answer < i:
        break
    answer += i
print(answer)
