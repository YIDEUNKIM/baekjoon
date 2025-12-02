from collections import deque
import sys
# 쉬운 계단 수 2
input = sys.stdin.readline

# 맨 끝이 0인 자리 수의 개수 = 이전 자리 수 중 1로 끝나는 수의 개수
# 맨 끝이 9인 자리 수의 개수 = 이전 자리 수 중 8로 끝나는 수의 개수
# 맨 끝이 j인 자리 수의 개수 = 이전 자리 수 중 j-1, j+1로 끝나는 수의 개수의 합

# dp[i][0] = dp[i-1][1]
# dp[i][9] = dp[i-1][8]
# dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] # j 1~8

n = int(input())

dp = [[0 for _ in range(10)] for _ in range(101)]

for k in range(1, 10):
    dp[1][k] = 1

for i in range(2, n+1):
    dp[i][0] = dp[i-1][1]
    dp[i][9] = dp[i-1][8]
    for j in range(1, 9):
        dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])

print(sum(dp[n]) % 1000000000)

