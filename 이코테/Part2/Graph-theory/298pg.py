N, M = map(int, input().split())
student = [] # idx = 학생, value = 부모(팀 중 적은 것)
for i in range(N+1):
    student.append(i)

answer = []

def find_root_renewel(student, x):
    if x == student[x]:
        return x
    else:
        student[x] = find_root_renewel(student, student[x])
        return student[x]


def merge_team(student,a, b):
    a_p = find_root_renewel(student, a)
    b_p = find_root_renewel(student, b)

    if a_p > b_p: # 작은것 이 부모로 합치기!!
        student[a] = student[b]
    else:
        student[b] = student[a]



def deff_team(student,a, b):
    a_p = find_root_renewel(student, a)
    b_p = find_root_renewel(student, b)

    if a_p == b_p:
        return False
    else:
        return True

for _ in range(M):
    flag, a, b = map(int, input().split())
    if flag:
        if deff_team(student, a, b):
            answer.append('NO')
        else:
            answer.append('YES')
    else:
        merge_team(student, a, b)
for i in answer:
    print(i)