N, M = map(int, input().split())
dduk = list(map(int, input().split()))

Max = max(dduk)
answer = 0

def BinarySearch(dduk, target, start, end):
    tmp = 0
    while(True):
        mid = (start + end) // 2

        if start > mid:
            break

        length = sizer(dduk, mid)
        if length >= target:
            start = mid + 1
            tmp = mid
        else:
            end = mid - 1

    return tmp

# 해당 길이로 자른 떡
def sizer(arr, lenth):
    answer = 0
    for i in arr:
        if i > lenth:
            answer += i - lenth
    return answer

print(BinarySearch(dduk, M, 0, Max))