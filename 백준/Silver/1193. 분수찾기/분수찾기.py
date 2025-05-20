x = int(input())

# 대각선 그룹 번호 찾기
line = 1 # 대각선 번호
while x > line:
    x = x - line
    line = line + 1

if line % 2 == 0: # 짝수 번째 대각선
    numerator = x
    denominator = line - x + 1
else: # 홀수 번째 대각선
    numerator = line -x + 1
    denominator = x

print(f"{numerator}/{denominator}")