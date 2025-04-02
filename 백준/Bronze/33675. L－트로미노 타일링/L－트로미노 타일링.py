T = int(input())
dp = [0] * (300)

dp[2] = 2

for i in range(1, T):
    dp[i*2+2] += 2*dp[i*2]

for i in range(T):
    k = int(input())

    if k % 2 ==1:
        print(0)
    else:
        print(dp[k])