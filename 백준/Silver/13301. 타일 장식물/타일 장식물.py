n = int(input())

dp = [0 for _ in range(81)]
fibo = [0 for _ in range(81)]
fibo[0] = 1
fibo[1] = 1
for i in range(2, 81):
    fibo[i] = fibo[i-1] + fibo[i-2]

dp[0] = 4
for i in range(1, 81):
    dp[i] = dp[i-1] + fibo[i] * 2

print(dp[n-1])
