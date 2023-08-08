point = input()
pre = point[:len(point)//2]
post = point[len(point)//2:]

a = 0
b = 0

for i in range(len(point)//2):
    a += int(pre[i])
    b += int(post[i])

if a == b:
    print('LUCKY')
else:
    print('READY')