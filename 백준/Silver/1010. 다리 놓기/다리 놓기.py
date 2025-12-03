from collections import deque
import sys
input = sys.stdin.readline
import math
k = int(input())

for i in range(k):
    n, m = map(int, input().split())
    print(int(math.factorial(m) / (math.factorial(n) * math.factorial(m-n))))
