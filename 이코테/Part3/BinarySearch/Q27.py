import sys
input = sys.stdin.readline
N, x = map(int, input().split())
arr = list(map(int, input().split()))
# 끝점 시작점 바꾸며 x 찾기
start = 0
end = N-1
answer = 0
while True:
    if start > end:
        answer = -1
        break
    if arr[(end + start)//2] < x:
        start = (end + start) // 2 + 1
    elif arr[(end - start)//2] > x:
        end = (end + start) // 2 - 1
    else:
        left = 0
        right = 0
        for i in range((end - start)//2, start, -1):
            if arr[i] == x:
                left += 1
        for i in range((end - start)//2, end):
            if arr[i] == x:
                right += 1
        answer = left + right - 1
        #print(left, right, answer)
        break
print(answer)

# 이거보다 왼쪽 오른쪽을 이진탐색 2번해서 찾는게 나음
# 또한 bisect 사용!!
