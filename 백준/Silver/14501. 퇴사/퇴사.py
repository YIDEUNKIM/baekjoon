import sys
input = sys.stdin.readline

N = int(input())
T = [0] * (N + 2)
P = [0] * (N + 2)

for i in range(1, N + 1):
    T[i], P[i] = map(int, input().split())

# dp[i] = i일부터 마지막까지 얻을 수 있는 최대 수익
dp = [0] * (N + 2)

for i in range(N, 0, -1):
    # 상담이 퇴사일을 넘어가면 못 함
    if i + T[i] > N + 1:
        dp[i] = dp[i + 1]
    else:
        # 상담을 하거나 안 하거나 중 최대
        dp[i] = max(dp[i + 1], P[i] + dp[i + T[i]])

print(dp[1])