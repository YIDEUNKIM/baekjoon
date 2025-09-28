# 거의 소수

import math
import sys

input = sys.stdin.readline
start, end = map(int, input().split())

a = [0] * (10000001)

for i in range(2, len(a)):
    a[i] = i

for i in range(2, int(math.sqrt(len(a)+1))): # 제곱근 까지만 수행
    if a[i] == 0:
        continue

    for j in range(i+i, len(a), i): # 배수 지우기
        a[j] = 0

cnt = 0
for i in range(2, 10000001):
    if a[i] != 0:
        temp = a[i]
        while(a[i] <= end/temp):
            if a[i] >= start / temp:
                cnt += 1

            temp = temp * a[i]

print(cnt)