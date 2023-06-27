N, M = map(int, input().split())
x, y, d = map(int, input().split())
arr = arr = [list(map(int, input().split())) for _ in range(M)]
answer = 0
flag = False
way = {0: [0, -1], 1: [1, 0], 2: [0, 1], 3: [-1, 0]}
arr[x][y] = 3

while(True):

    # 4방향 다 갈 곳 없으면
    if flag:
        tmpx = x - way[d][0]
        tmpy = y - way[d][1]
        # 이동할 뒷방향이 바다이면
        if arr[tmpx][tmpy] == 1:
            print(answer)
            break
        # 가본 곳이면
        else:
            x = tmpx
            y = tmpy
            answer = answer + 1
            print(x, y)

    for _ in range(4):
        flag = True
        #1. 회전부터
        d = (d+3)%4
        #2. 앞 방향 확인
        tmpx = way[d][0] + x
        tmpy = way[d][1] + y
        #3. 바다인지, 가본곳인지 확인
        if arr[tmpx][tmpy] == 1 or arr[tmpx][tmpy] == 3:
            continue
        #3. 바다도 아니고 가본곳 아니면 이동 후 가본곳 처리
        else:
            x = tmpx
            y = tmpy
            arr[x][y] = 3
            print(x, y)
            answer = answer + 1
            flag = False
            break

