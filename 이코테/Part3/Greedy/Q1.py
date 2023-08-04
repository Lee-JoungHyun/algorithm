N = int(input())
adv = list(map(int, input().split()))
#1. adv 오름차순 정렬
adv.sort()
print(adv)
answer = 0
i = 0
while i < len(adv):
    print(i)
    tmp = [adv[i]]
    cnt = 0
    while(True):
        if max(tmp) <= len(tmp):
            print(tmp)
            answer += 1
            break
        else:
            cnt += 1
            if i+cnt >= N:
                break
            tmp.append(adv[i+cnt])
    i += cnt
    i += 1


print(answer)

# 17분, O(NlongN)
