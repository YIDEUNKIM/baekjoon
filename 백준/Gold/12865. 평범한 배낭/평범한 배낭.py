n, k = map(int, input().split())
weight = []
value = []



for i in range(n):
    w, v = map(int, input().split())
    weight.append(w)
    value.append(v)

dp = [[0 for _ in range((k+1))] for _ in range(n+1)]

for i in range(1, n+1):
    for w in range(1, k+1):
        if weight[i-1] <= w:
            dp[i][w] = max(dp[i-1][w],
                           dp[i-1][w-weight[i-1]] + value[i-1])
        else:
            dp[i][w] = dp[i-1][w]

print(max(map(max, dp)))