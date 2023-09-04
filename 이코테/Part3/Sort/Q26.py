import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []
for i in range(N):
    heapq.heappush(heap, int(input()))
answer = 0
while len(heap) != 1:
    one = heapq.heappop(heap)
    two = heapq.heappop(heap)
    sum_value = one + two
    answer += sum_value
    heapq.heappush(heap, sum_value)

print(answer)