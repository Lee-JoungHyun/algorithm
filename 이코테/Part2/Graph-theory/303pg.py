N = int(input())

lecture = [0] * (N + 1)
lecture[0] = [] # 선수과목 정보가 들어있는 2차원 배열
lect_time = [0] * (N + 1)
answer = [0] * (N + 1)
step = []


for i in range(1, N+1):
    tmp = list(map(int, input().split()))
    lect_time[i] = tmp[0] # 시간
    tmp.pop(0)
    tmp.pop(-1) # -1 빼기
    if len(tmp) == 0: # 선수과목 없으면 step 에 추가
        step.append(i)
    lecture[i] = tmp

for i in step:
    answer[i] = lecture[i]


# step 는 선수 과목이 완료된 것들
while(True):
    nextStep = []
    for now in step: # 선수과목이 완료 된 것들
        #1. 본인 선수과목의 시간 중 가장 큰 것을 가져와 그것에 자신의 시간 더해서 본인 시간 정하기
        answer[now] = lect_time[now] + (max(list(map(lambda x:answer[x], lecture[now]))) if list(map(lambda x:answer[x], lecture[now])) else 0)
        #2. 본인 후행과목중 선수과목이 다 완료되면 후행과목 다음 step에 추가
        for i in range(len(lecture)): # i 는 lectuer 범위
            if now in lecture[i]: # 본인이 선행과목에 포함된 경우 (lectuer[i] = now를 선행과목으로 하는 것의 선행과목문)
                print(list(map(lambda x:answer[x], lecture[i])))
                if 0 != min(list(map(lambda x:answer[x], lecture[i]))) : # 선행과목이 모두 완료된 것
                    nextStep.append(i)

    step.clear()
    step = nextStep[:]
    print(answer)
    if min(answer[1:]) != 0:
        break

for i in range(1, len(answer)):
    print(answer[i])




