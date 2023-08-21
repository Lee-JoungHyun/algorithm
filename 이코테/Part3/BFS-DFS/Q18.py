def reverse(str):
    tmp = ''
    for i in str:
        if i == '(':
            tmp += ')'
        elif i == ')':
            tmp += '('
    return tmp

def doing(str):
    u = ''
    v = ''
    leftcnt = 0
    rightcnt = 0
    if len(str) == 0:
        return ""
    for i in range(len(str)):
        if leftcnt == rightcnt and not leftcnt == 0:
            v += str[i]
        elif str[i] == '(':
            leftcnt += 1
            u += str[i]
        elif str[i] == ')':
            rightcnt += 1
            u += str[i]
    if seper(u) == 1:
        return u + doing(v)
    elif seper(u) == 0:
        return '(' + doing(v) + ')' + reverse(u[1:-1])

def seper(str):
    leftcnt = 0
    rightcnt = 0
    open = 0
    flag = False
    for i in str:
        if i == '(':
            leftcnt += 1
            open += 1
        elif i == ')':
            rightcnt += 1
            open -= 1
            if open < 0:
                flag = True
    if leftcnt == rightcnt and flag: # 균형 잡힌 문자열
        return 0
    elif leftcnt == rightcnt: # 올바른 문자열
        return 1
    else:
        return 2




def solution(p):
    # 균형잡힌 문자열 확인
    leftcnt = 0
    rightcnt = 0
    flag = True
    # 균잡 or 올바른 인지 확인
    sep = seper(p)
    if len(p) == 0:
        return ''
    if sep == 1:
        return p
    elif sep == 0:
        return doing(p)


w = input()
print(solution(w))





