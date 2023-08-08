def word_sort(arr, word):
    answer = ''
    flag = True
    flag2 = True
    for i in arr:
        if i > word and flag2:
            flag = False
            flag2 = False
            answer += word
        answer += i
    if flag:
        answer += word
    #print(answer)
    return answer


word = input()
num = 0
wo = ''
for i in word:
    if i.isdigit():
        num += int(i)
    else:
        wo = word_sort(wo, i)

#print(wo)

print(wo, num, sep='')
