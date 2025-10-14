import math
n = int(input())

a = []
a.append(n)

for i in range(1, n):
    if i % 2 == 1:
        a.append(a[i-1] - (n-i))
    else:
        a.append(a[i - 1] + (n-i))

a.reverse()
print(*a)