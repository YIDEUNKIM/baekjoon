n, k = map(int, input().split())
coins = []
for i in range(n):
    coins.append(int(input()))

dp = [10001 for _ in range(k+1+max(coins))]
dp[0] = 0

for w in range(0, k+1):
    if dp[w] != 10001:
        for c in range(n):
            dp[w+coins[c]] = min(dp[w+coins[c]], dp[w] + 1)
if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])