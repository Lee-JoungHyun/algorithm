N, K = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort()
print(a, b)

for i in range(K):
    aflag = True
    bflag = True
    if a[0] > b[-1]:
        pass
    else:
        for j in range(len(a)):
            if a[j] > b[-1]:
                a.insert(j, b[-1])
                aflag = False
                break
        if aflag:
            a.insert(len(a), b[-1])
        b.pop(len(b)-1)

        for j in range(len(b)):
            if b[j] > a[0]:
                b.insert(j, a[0])
                bflag = False
                break
        if bflag:
            b.insert(len(b), a[0])
        a.pop(0)

    print(a, b)
answer = 0
for i in a:
    answer += i
print(answer)
