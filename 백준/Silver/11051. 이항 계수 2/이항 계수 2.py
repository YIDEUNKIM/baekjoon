from collections import deque
import sys
from itertools import combinations
input = sys.stdin.readline
import math
n, m = map(int, input().split())

dp = [[0 for _ in range(n+1)] for _ in range(n+1)]

for i in range(1,n+1):
    dp[i][1] = i
    dp[i][0] = 1
    dp[i][i] = 1


for i in range(2, n+1):
    for j in range(2, m+1):
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j]

print(dp[n][m] % 10007)