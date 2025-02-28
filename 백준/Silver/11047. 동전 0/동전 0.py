n, k = map(int, input().split())
a = []
for i in range(n):
    a.append(int(input()))

count = 0
for i in range(n-1, -1, -1):

    if a[i] - k > 0:
        pass
    elif a[i] - k <= 0:
        count = count + k // a[i]
        k = k % a[i]


print(count)
