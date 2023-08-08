s = input()
answer = int(1e9) # answer 은 지금까지 나온 값 중 최솟값
duple = []
for i in range(1, len(s)): # i는 자를 문자열의 단위
    if answer < i:
        break
    length = len(s) # 자를 문자열의 길이
    duple.clear()
    for j in range(len(s)-i): # j는 시작 위치
        tmp = 1
        cnt = 0
        while j+i*tmp+i <= len(s):
            if s[j:j+i] == s[j+i*tmp:j+i*tmp+i]:
                #print(s[j:j+i], s[j+i*tmp:j+i*tmp+i])
                cnt += 1
                tmp += 1
            else:
                if tmp > 1:
                    flag2 = True
                    for k in duple:
                        print('비교', k[0], j, k[1])
                        if j > k[0] and j < k[1]:
                            if -(i*(tmp-1)) + len(str(cnt)) < k[2]:
                                k[0] = j
                                k[1] = j + i * (tmp-1) + i - 1
                                k[2] = -(i*(tmp-1)) + len(str(cnt))
                                flag2 = False
                    if flag2:
                        print((j, j + i * (tmp-1) + i - 1, -(i*(tmp-1)) + len(str(cnt))))
                        duple.append([j, j + i * (tmp-1) + i - 1, -(i*(tmp-1)) + len(str(cnt))])
                        print(duple)
                #length = length + len(str(cnt))
                break
            if j+i*tmp+i >= len(s) and tmp > 1:
                flag2 = True
                if tmp > 1:

                    for k in duple:
                        print('비교', k[0], j, k[1])
                        if j > k[0] and j < k[1]:
                            if -(i * (tmp - 1)) + len(str(cnt)) <= k[2]:
                                k[0] = j
                                k[1] = j + i * (tmp - 1) + i - 1
                                k[2] = -(i * (tmp - 1)) + len(str(cnt))
                            flag2 = False
                    if flag2:
                        print((j, j + i * (tmp - 1) + i - 1, -(i * (tmp - 1)) + len(str(cnt))))
                        duple.append([j, j + i * (tmp - 1) + i - 1, -(i * (tmp - 1)) + len(str(cnt))])
                        print(duple)
                # length = length + len(str(cnt))



    print(duple)
    tmp2 = 0
    for f in duple:
        tmp2 += f[2]
    length += tmp2
    if answer > length:
        answer = length


print(answer)

## 실패.. 구현문제 다시

