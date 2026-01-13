import sys
input = sys.stdin.readline

q = int(input())
lst = []
log = []
result = []

for _ in range(q):
    a = input().split()  # 수정: split() 사용
    if a[0] == '1':
        lst.append(a[1])  # 수정: a[1]
        log.append((1, a[1]))
    elif a[0] == '2':
        last = lst[-1]
        log.append((2, last))
        lst.pop()
    elif a[0] == '3':
        j = int(a[1])  # 수정: a[1]
        for _ in range(j):
            key, value = log.pop()
            if key == 1:
                lst.pop()
            elif key == 2:
                lst.append(value)
    elif a[0] == '4':
        result.append(len(lst))
    elif a[0] == '5':
        if len(lst) == 0:
            result.append(-1)
        else:
            result.append(lst[-1])

print('\n'.join(map(str, result)))