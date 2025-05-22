n = int(input())

max_hp = 100
l = list(map(int, input().split()))
j = list(map(int, input().split()))

dp = [[0 for _ in range(max_hp+1)] for _ in range(n+1)]
for i in range(1, n + 1):
    for w in range(1, max_hp + 1):
        if l[i - 1] < w: # l 이 w보다 작
            dp[i][w] = max(
                dp[i - 1][w],
                dp[i-1][w-l[i-1]] + j[i-1]
            )
        else:
            dp[i][w] = dp[i-1][w]

print(dp[n][max_hp])