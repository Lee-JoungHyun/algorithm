from collections import deque

def turn_L(dir):
    return (dir+3)%4
def turn_R(dir):
    return (dir+1)%4

N = int(input())
board = [[0 for j in range(N)] for i in range(N)]
board[0][0] = 1
K = int(input())
apple = []
change_dir = {}
for _ in range(K):
    x, y = map(int, input().split())
    board[y-1][x-1] = 2
L = int(input())
for _ in range(L):
    t, d = input().split()
    change_dir[int(t)] = d

dict_dir = { 0:[1, 0], 1:[0, 1], 2:[-1, 0], 3:[0, -1] }

time = 0
head = [0, 0]
tail = [0, 0]
queue = deque([head])
length = 1
dir = 0
while True:
    ndir = dict_dir[dir]
    next = [head[0] + ndir[0], head[1] + ndir[1]]
    # 종료 조건 확인
    #print(next[0], next[1], queue, time)
    if next[0] >= N or next[1] >= N or next[0] < 0 or next[1] < 0 or board[next[0]][next[1]] == 1:
        time += 1
        break
    """
    # 벽과 부딛칠 조건
    if (head[0] != 0 and next[0] == 0) or (head[1] != 0 and next[1] == 0):
        time += 1
        break
    """
    queue.append(next)

    head = [next[0], next[1]]
    # 진행시 사과이면 head만 변경, 사과자리 -> 몸
    if board[next[0]][next[1]] == 2:
        pass
    elif board[next[0]][next[1]] == 0:
        trash = queue.popleft()
        board[trash[0]][trash[1]] = 0
        ntail = queue.popleft()
        tail = ntail
        queue.appendleft(tail)
    board[next[0]][next[1]] = 1

    time += 1
    if time in change_dir:
        if change_dir[time] == 'D':
            dir = turn_R(dir)
        elif change_dir[time] == 'L':
            dir = turn_L(dir)

print(time)




