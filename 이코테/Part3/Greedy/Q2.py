num = input()

answer = max(int(num[0]) + int(num[1]), int(num[0]) * int(num[1]))
for i in range(2, len(num)):
    answer = max(answer + int(num[i]), answer * int(num[i]))

print(answer)

#6분 O(N) (길이)