N, M = map(int, input().split())
dduk = list(map(int, input().split()))

Max = max(dduk)
answer = 0

def BinarySearch(arr, target, start, end):
    global answer
    if start > end:
        return None
    mid = (start + end) // 2
    if sizer(dduk, mid) >= M:
        if mid > answer:
            answer = mid

# 해당 길이로 자른 떡
def sizer(arr, lenth):
    answer = 0
    for i in arr:
        if i > lenth:
            answer += i - lenth
    return answer

print(answer)