import sys
input = sys.stdin.readline
N = int(input())
meeting = []
for _ in range(N):
    meeting.append(list(map(int, input().split())))
meeting.sort(key=lambda x: (x[1]-x[0], x[0]))

timeTable = []
answer = 0
for m in meeting:
    flag = True
    for i in timeTable:
        if i[0] < m[0] < i[1] or i[0] < m[1] < i[1] or (m[0] < i[0] and m[1] > i[1]) or m[0] == i[0] or m[1] == i[1]:
            flag = False
    if flag:
        answer += 1
        timeTable.append(m)

print(answer)




