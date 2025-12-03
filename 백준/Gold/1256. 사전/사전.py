import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())

# N, M이 최대 100이므로 N+M은 최대 200
# 넉넉하게 202 x 202로 생성 (0번 인덱스 포함)
dp = [[0] * 202 for _ in range(202)]

for i in range(201):
    dp[i][0] = 1
    dp[i][1] = i
    dp[i][i] = 1


# 초기화 및 DP 채우기
for i in range(1, 201):

    for j in range(1, i):
        # 점화식: nCr = n-1Cr-1 + n-1Cr
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        # (선택) K가 10억 범위이므로 오버플로우 방지 및 최적화를 위해 상한선 컷
        if dp[i][j] > 1000000000:
            dp[i][j] = 1000000001
result = ""

if dp[N+M][M] < K:
    print(-1)
else:
    while N > 0 or M > 0:
        if dp[N-1+M][M] >= K: # a를 선택할 수 있는 경우
            result += "a"
            N -= 1 # a를 하나 사용
        else:
            result += "z"
            K -= dp[N-1+M][M]
            M -= 1

    print(result)