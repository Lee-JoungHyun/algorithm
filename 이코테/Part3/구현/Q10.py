def key_turn_right(key):
    length = len(key)
    keytmp = []
    for i in key:
        keytmp.append(i[:])
    for i in range(length):
        for j in range(length):
            keytmp[i][j] = key[length - 1 - j][i]
    return keytmp

def fit(key, lock, x, y, hom):
    length_key = len(key)
    length_lock = len(lock)
    fix = 0
    # x가 오른쪽으로 움직였을 경우 lock 범위 (x ~ length) 왼쪽 = (0 ~ length-x)
    # 이때 키가 lock보다 작으면 (x ~ length_key), 왼쪽 = 0~
    for i in range(x if x > 0 else 0, length_lock if x > 0 else length_key + x):
        # y 가 아래쪽으로 움직였을 경우 (y ~ length)
        for j in range(y if y > 0 else 0, length_lock if y > 0 else length_key + y):
            if lock[i][j] == 0 and key[i-x][j-y] == 1:
                fix += 1
    if hom == fix:
        return True

def fit_turn4(key, lock, x, y, hom):
    for i in range(4):
        if fit(key, lock, x, y, hom):
            return True
        key = key_turn_right(key)
    return False


def solution(key, lock):
    length_key = len(key)
    length_lock = len(lock)
    hom = 0
    for i in lock:
        for j in i:
            if j == 0:
                hom += 1
    for x in range(-(length_key-1), length_lock):
        for y in range(-(length_key-1), length_lock):
            if fit_turn4(key, lock, x, y, hom):
                return True
    return False

print(solution(([0,0,0], [1,0,0], [0,1,1]), ([1,1,1], [1,1,0], [1,0,1])))