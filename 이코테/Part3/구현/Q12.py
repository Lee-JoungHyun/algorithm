def build(x, y, a, ans):
    ans.append([x, y, a])


def crush(x, y, a, ans):
    if [x, y, a] in ans:
        ans.remove([x, y, a])


def check(ans):
    for stp in ans:
        x = stp[0]
        y = stp[1]
        if stp[2] == 0: # 기둥일 경우
            if not (y == 0 or [x, y-1, 0] in ans or [x, y, 1] in ans or [x-1, y, 1] in ans):
                return False
        if stp[2] == 1: # 보일 경우
            if not ([x, y-1, 0] in ans or [x+1, y-1, 0] in ans or ([x-1, y, 1] in ans and [x+1, y, 1] in ans)):
                return False
    return True

answer = []
#####
N = int(input())
bulid_frame = []
inputtmp = input()
#####
tmp = []
for i in inputtmp[:-1]:
    if i == ']':
        bulid_frame.append(tmp[:])
        tmp.clear()
    elif i.isdigit():
        tmp.append(int(i))

for stp in bulid_frame:
    if stp[3] == 0:  # 삭제
        tmp = answer[:]
        crush(stp[0], stp[1], stp[2], tmp)
        if check(tmp):
            crush(stp[0], stp[1], stp[2], answer)
    else:  # 설치
        tmp = answer[:]
        build(stp[0], stp[1], stp[2], tmp)
        if check(tmp):
            build(stp[0], stp[1], stp[2], answer)
    print(answer)

answer.sort()
print(answer)
