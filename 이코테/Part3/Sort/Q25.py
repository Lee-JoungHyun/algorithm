def solution(N, stages):
    answer = []
    player = len(stages)
    for stage in range(1, N + 1):
        num = stages.count(stage)
        if player <= 0:
            answer.append([stage, 0])
        else:
            answer.append([stage, num / player])
            player -= num

    answer.sort(key=lambda x: x[1], reverse=True)
    tmp = []
    for i in answer:
        tmp.append(i[0])
    return tmp