import sys
input = sys.stdin.readline

MOD = 1000000007

N, L, R = map(int, input().split())

# dp[n][l][r] = 빌딩 n개, 왼쪽에서 l개, 오른쪽에서 r개 보이는 경우의 수
dp = [[[0] * (N + 1) for _ in range(N + 1)] for _ in range(N + 1)]
dp[1][1][1] = 1

for n in range(2, N + 1):
    for l in range(1, n + 1):
        for r in range(1, n - l + 2):
            # 맨 왼쪽에 가장 작은 빌딩 배치
            if l >= 1:
                dp[n][l][r] = (dp[n][l][r] + dp[n-1][l-1][r]) % MOD
            # 맨 오른쪽에 가장 작은 빌딩 배치
            if r >= 1:
                dp[n][l][r] = (dp[n][l][r] + dp[n-1][l][r-1]) % MOD
            # 중간에 배치 (n-2개의 위치)
            dp[n][l][r] = (dp[n][l][r] + dp[n-1][l][r] * (n - 2)) % MOD

print(dp[N][L][R])