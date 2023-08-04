def min_not0(arr):
    min = int(1e9)
    for i in arr:
        if i > 0 and i < min:
            min = i
    return min


def sub_num(arr, num):
    for i in range(len(arr)):
        if arr[i] > 0:
            arr[i] -= num

    return arr[:]


def solution(food_times, k):
    cnt_food = len(food_times)  # 배열에 남아있는 음식 수
    while (True):
        print(food_times, k)

        min_value = min_not0(food_times)  # 현재 배열에서 가장 작은 값(0제외)
        cnt = food_times.count(min_value)  # 가장 작은 값의 개수

        if k < cnt_food * min_value:  # 남아 있는 시간이 작으면
            break

        food_times = sub_num(food_times, min_value)  # 배열에 가장 작은 값으로 전체 빼기

        k -= (cnt_food * min_value)  # 시간 갱신
        cnt_food -= cnt  # 남아있는 음식 수 갱신

    answer = 0
    while True:
        if food_times[answer] > 0:
            k -= 1
        print(answer, k)
        answer = (answer+1) % len(food_times)

        if k <= 0:
            break

    print(answer)
    return answer

print(solution([3,1,2], 5))