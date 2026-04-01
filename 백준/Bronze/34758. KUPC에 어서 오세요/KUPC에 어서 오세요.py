x, y = map(int, input().split())
n = int(input())

for i in range(n):
    x_i, y_i = map(int, input().split())

    if x_i == x or y_i == y:
        print(0)
    else:
        print(1)