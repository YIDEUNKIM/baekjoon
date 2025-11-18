import sys

sys.setrecursionlimit(1000000)

def union(a, b):
    a = find(a)
    b = find(b)

    if (a <= b):
        lst[b] = a
    else:
        lst[a] = b

def find(n):
    if n != lst[n]:
        lst[n] = find(lst[n])

    return lst[n]

n, m = map(int, input().split())

lst = []
for i in range(0, n+1):
    lst.append(i)

for i in range(m):
    x, a, b = map(int, input().split())

    if x == 0:
        union(a, b)
    else:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")