import sys
t = int(sys.stdin.readline().rstrip())

for i in range(t):
    cloth = {}
    result = 1
    n = int(input())
    for j in range(n):
        name, type = map(str, input().split())

        if not type in cloth: # 처음 입력된 타입이라면
            cloth[type] = 1
        else:
            cloth[type] += 1

    for i in cloth:
        result *= (cloth[i] +1)

    print(result-1)
