t = int(input())
n = []
result = []
for i in range(t):
    n = list(map(int, input().split()))

    run = []
    trick = []
    
    run.append(n[0])
    run.append(n[1])

    trick.append(n[2])
    trick.append(n[3])
    trick.append(n[4])
    trick.append(n[5])
    trick.append(n[6])

    run.sort()
    trick.sort(reverse=True)


    result.append(trick[0]+trick[1]+run[1])


print(max(result))

