N = int(input())
part = list(map(int, input().split()))
M = int(input())
need = list(map(int, input().split()))

parttmp = sorted(part)

def BinarySearch(arr, target, start, end):
    if start > end:
        return False
    mid = (start+end)//2
    if arr[mid] == target:
        print(target)
        return True

    elif arr[mid] > target:
        return BinarySearch(arr, target, start, mid-1)
    else:
        return BinarySearch(arr, target, mid+1, end)

answer = []
for i in need:
    if BinarySearch(parttmp, i, 0, N-1):
        answer.append('yes')
    else:
        answer.append('no')

for i in answer:
    print(i, end=' ')
