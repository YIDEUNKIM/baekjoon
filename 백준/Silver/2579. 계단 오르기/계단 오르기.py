n = int(input())  # 계단 개수 입력
stair = [0] * (n + 1)  # 계단 점수 저장 (1-based index)
for i in range(1, n + 1):
    stair[i] = int(input())

# DP 배열 초기화
dp = [0] * (n + 1)

# 초기 조건
if n >= 1:
    dp[1] = stair[1]
if n >= 2:
    dp[2] = stair[1] + stair[2]

# 점화식 적용
for i in range(3, n + 1):
    dp[i] = max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i])

# 결과 출력
print(dp[n])