N, M = map(int, input().split()) # N = 화폐종류, M = 금액, arr = 화폐 가치 정렬
arr = []

dic = {}

for _ in range(N):
    tmp = int(input())
    arr.append(tmp)
    dic[tmp] = 1

# 1. 1부터 하나씩 올라가면서 자신을 만들 수 있는지 확인하기 -> 자신에서 화폐종류를 뺀 값이 dic에 존재하면 그 값+1을 dic에 추가하기!
for i in range(max(arr)+1, M+1):
    tmp = float('inf')
    for j in arr:
        if i - j in dic:
            if dic[i-j] < tmp:
                tmp = dic[i-j]
    dic[i] = tmp+1
    print(i, '는', dic[i], '개')

if M in dic:
    print(dic[M])
else:
    print(-1)




