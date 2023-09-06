def solution(words, queries):
    answer = []
    re_w = []
    for i in words:
        re_w.append(i[::-1])
    words.sort(key=lambda x: (len(x), x))
    re_w.sort(key=lambda x: (len(x), x))
    for qu in queries:
        if qu[0] == '?':
            qu = qu[::-1]
            answer.append(find(re_w, qu))
        else:
            answer.append(find(words, qu))
    return answer

def find(words, find):
    f = 0
    e = -1
    start = 0
    end = len(words)-1
    length = len(find)
    find = find.replace('?', '')
    size = len(find)
    # 1. 시작점 찾기
    while start <= end:
        mid = (start + end) // 2
        if words[mid][:size] == find and len(words[mid]) == length:  # 같을 때
            if mid == 0:
                f = 0
                break
            elif words[mid - 1][:size] == find and len(words[mid - 1]) == length: # 전 단어가 같으면
                end = mid - 1
            else:
                f = mid
                break
        elif len(words[mid]) < length:
            start = mid + 1
        elif len(words[mid]) > length:
            end = mid - 1
        elif words[mid] > find:
            end = mid - 1
        elif words[mid] < find:
            start = mid + 1
    # 1. 끝점 찾기
    start = 0
    end = len(words) - 1
    while start <= end:
        mid = (start + end) // 2
        if words[mid][:size] == find and len(words[mid]) == length:    # 같을 때
            if mid == len(words) - 1:
                e = len(words) - 1
                break
            elif words[mid + 1][:size] == find and len(words[mid + 1]) == length:
                start = mid + 1
            else:
                e = mid
                break
        elif len(words[mid]) < length:
            start = mid + 1
        elif len(words[mid]) > length:
            end = mid - 1
        elif words[mid] > find:
            end = mid - 1
        elif words[mid] < find:
            start = mid + 1

    return e - f + 1

words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
qureries = ["fro??", "????o", "fr???", "fro???", "pro?"]
print(solution(words, qureries))