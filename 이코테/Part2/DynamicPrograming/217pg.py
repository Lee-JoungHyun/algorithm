N = int(input())

arr = [0]*150005
count = 1
find = [1]
flag = False
while(True):
    tmp = []
    for i in find:

        if i*5 == N or i*3 == N or i * 2 == N or i + 1 == N:
            print(count)
            flag = True

        if arr[i*5] == 0:
            arr[i*5] = count
            tmp.append(i*5)

        if arr[i*3] == 0:
            arr[i*3] = count
            tmp.append(i*3)

        if arr[i*2] == 0:
            arr[i*2] = count
            tmp.append(i*2)

        if arr[i+1] == 0:
            arr[i+1] = count
            tmp.append(i+1)

    if flag:
        break
    count += 1
    find.clear()
    find = tmp





