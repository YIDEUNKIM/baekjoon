t = int(input())

for i in range(t):
    n = int(input())

    visited = [False] * (n+1)

    lst2 = [0]
    lst2.extend(map(int, input().split()))

    index = 1

    cnt = 0

    for i in range(1, n+1):
        value = lst2[i]

        if visited[value] == False:
            while True:
                visited[value] = True
                value = lst2[value]

                if visited[value]:
                    cnt+=1
                    break
        else:
            continue

    print(cnt)