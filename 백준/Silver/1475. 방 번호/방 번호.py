import math

n = input()
num = list(map(int, list(n)))  # 입력받은 문자열을 정수 리스트로 변환
counts = [0] * 10  # 각 숫자의 개수를 저장하는 리스트

for digit in num:
    if digit == 9:
        counts[6] += 1
    else:
        counts[digit] += 1

counts[6] = math.ceil(counts[6] / 2)  # 6과 9는 함께 사용 가능하므로 2로 나눈 후 올림

print(max(counts))