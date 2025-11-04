n = int(input())

lst1 = list(map(int, input().split()))

dp = [0 for _ in range(n)]


ans = 0
for i in range(n):
    current = 0
    for j in range(i):
        if lst1[i] > lst1[j]:
            current = max(current, dp[j])
    dp[i] = current + 1
    ans = max(ans, dp[i])

print(ans)