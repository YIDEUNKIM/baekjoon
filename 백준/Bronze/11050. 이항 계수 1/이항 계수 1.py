from collections import deque
import sys
from itertools import combinations
input = sys.stdin.readline
import math
n, m = map(int, input().split())

print(int(math.factorial(n) / (math.factorial(m) * math.factorial(n-m))))
