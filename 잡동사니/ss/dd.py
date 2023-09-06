import sys
input = sys.stdin.readline

n = int(input())

meeting = []
for _ in range(n):
    meeting.append(list(map(int, input().split())))

meeting.sort(key = lambda x:(x[1], x[0]))
print(meeting)
end = meeting[0][1]
count = 1
for i in range(1, n):
    if meeting[i][0] >= end:
        count += 1
        end = meeting[i][1]
print(count)