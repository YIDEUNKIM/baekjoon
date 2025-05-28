import math
N, M = map(int, input().split())

result = 0

if N == M:
    result = (N-2)**2 + 1
elif N < M:
    result = (N-1)**2
else:
    result = (M-1)**2

print(int(result))