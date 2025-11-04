s1 = input()
s2 = input()

n = max(len(s1), len(s2))

dp = [[0]*(n+1) for _ in range(n+1)]

for i in range(0, len(s1)):
    for j in range(0, len(s2)):
        if s1[i] == s2[j]:
            dp[i+1][j+1] = dp[i][j] + 1

        else:
            dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])

print(max(map(max, dp)))