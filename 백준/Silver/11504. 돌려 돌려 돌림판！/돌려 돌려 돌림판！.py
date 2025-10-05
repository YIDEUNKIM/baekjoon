from collections import deque

t = int(input())

for i in range(t):
    n, m = map(int, input().split())
    x_list = list(map(str, input().split()))
    y_list = list(map(str, input().split()))
    x = ""
    y = ""
    for i in x_list:
        if i == " ":
            continue
        else:
            x += i
    for i in y_list:
        if i == " ":
            continue
        else:
            y += i

    x = int(x)
    y = int(y)

    circle = list(map(str, input().split()))
    m_circle = []
    for i in range(len(circle)):
        a = ""

        for j in range(m):
            a += circle[(i+j) % len(circle)]
        m_circle.append(int(a))

    cnt = 0
    for z in m_circle:
        if x <= z <= y:
            cnt+= 1

    print(cnt)