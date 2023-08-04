N = input()
cnt0 = 0
cnt1 = 0
# 0이면 flag True
if N[0] == '0':
    flag = True
for i in N:
    if i == '0': #0일때
        if not flag: # 전이 1이면
            flag = True # 앞으로 0이됨
            cnt1 += 1 # 0덩이 +1
    else: # 1일때
        if flag: # 전이 0이면
            flag = False
            cnt0 += 1

print(min(cnt0, cnt1))

# 10분 N

