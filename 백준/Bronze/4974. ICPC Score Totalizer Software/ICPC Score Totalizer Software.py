while True:
    n = int(input())
    a = []

    if n==0:
        break

    for _ in range(n):
        i = int(input())
        a.append(i)

    a.sort()
    print(sum(a[1:len(a)-1]) // (len(a)-2))


