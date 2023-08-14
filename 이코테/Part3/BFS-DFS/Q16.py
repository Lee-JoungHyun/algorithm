import sys
from itertools import combinations
input = sys.stdin.readline
#list(combinations(chicken, M))
N, M = map(int, input().split()) # 세로, 가로
virus = []
safe = []
for n in range(N):
    b = input().strip()
    a = b.replace(" ", "")
    for m in range(M):
        if a[m] == '0':
            safe.append([m, n])
        elif a[m] == '2':
            virus.append([m, n])

def spread(virus, safe):
    safet = safe[:]
    print(safet)
    print(safe)
    while len(virus) > 0:
        tmp = virus.pop()
        print(len(safet))
        if [tmp[0]+1, tmp[1]] in safet:
            print([tmp[0]+1, tmp[1]], safet)
            safet.remove([tmp[0]+1, tmp[1]])
            virus.append([tmp[0]+1, tmp[1]])
        elif [tmp[0]-1, tmp[1]] in safet:
            safet.remove([tmp[0]-1, tmp[1]])
            virus.append([tmp[0]-1, tmp[1]])
        elif [tmp[0], tmp[1]+1] in safet:
            safet.remove([tmp[0]+1, tmp[1]])
            virus.append([tmp[0]+1, tmp[1]])
        elif [tmp[0], tmp[1]-1] in safet:
            safet.remove([tmp[0]-1, tmp[1]])
            virus.append([tmp[0]-1, tmp[1]])
    return len(safet)
answer = []

for step in list(combinations(safe, 3)):
    safetmp = safe[:]
    for i in step: # 안전구역에서 wall 이 될 것들 3개
        safetmp.remove(i)
    dd = spread(virus[:], safetmp)
    answer.append(dd)

print(max(answer))






