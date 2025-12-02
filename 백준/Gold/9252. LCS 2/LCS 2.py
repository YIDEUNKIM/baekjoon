import sys
input = sys.stdin.readline

s1 = input().strip()
s2 = input().strip()

n = len(s1)
m = len(s2)

# dp 테이블에 숫자 0 대신 빈 문자열 ""로 초기화
dp = [["" for _ in range(m + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        if s1[i-1] == s2[j-1]:
            # 문자가 같으면: 대각선 문자열 + 현재 문자
            dp[i][j] = dp[i-1][j-1] + s1[i-1]
        else:
            # 문자가 다르면: 왼쪽과 위쪽 문자열 중 '길이가 더 긴 것' 선택
            if len(dp[i-1][j]) > len(dp[i][j-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i][j-1]

# 역추적 없이 그냥 맨 끝방 출력하면 끝!
print(len(dp[n][m]))
print(dp[n][m])