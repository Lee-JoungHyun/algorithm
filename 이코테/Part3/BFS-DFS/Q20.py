import sys
from itertools import combinations
input = sys.stdin.readline
def check(student, teacher, wall, N):
    std = student[:]
    tea = teacher[:]
    w = wall[:]

    for t in tea:
        y = t[0]
        x = t[1]
        for i in range(y-1, -1, -1): # y-1 ~ 0 까지 y축
            if [i, x] in w:
                break
            if [i, x] in std:
                std.remove([i, x])
        for i in range(y+1, N):
            if [i, x] in w:
                break
            if [i, x] in std:
                std.remove([i, x])
        for i in range(x-1, -1, -1): # X축 검사
            if [y, i] in w:
                break
            if [y, i] in std:
                std.remove([y, i])
        for i in range(x+1, N):
            if [y, i] in w:
                break
            if [y, i] in std:
                std.remove([y, i])

    if len(std) == len(student):
        return True
    else:
        return False

N = int(input())
student = []
teacher = []
space = []

for i in range(N): # 세로
    tmp = input().replace(" ", "")
    for j in range(N): # 가로
        if tmp[j] == 'S':
            student.append([i, j])
        elif tmp[j] == 'T':
            teacher.append([i, j])
        else:
            space.append([i, j])

flag = True
for wall in list(combinations(space, 3)):
    if check(student, teacher, wall, N):
        print('YES')
        flag = False
        break

if flag:
    print('NO')





