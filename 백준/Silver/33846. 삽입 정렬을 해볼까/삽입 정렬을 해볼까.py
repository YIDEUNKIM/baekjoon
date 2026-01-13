import sys
n, t = map(int, sys.stdin.readline().split())

a = list(map(int, sys.stdin.readline().split()))
front_a = sorted(a[:t])

back_a = a[t:]
result = front_a + back_a
print(*result)