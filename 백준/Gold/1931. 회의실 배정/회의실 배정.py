from collections import deque
import sys
# 회의실 배정하기
input = sys.stdin.readline

n = int(input())
time = []
for _ in range(n):
    start, end = map(int, input().split())
    time.append((start, end))

time.sort(key=lambda x: (x[1], x[0]))

result = []
result.append(time[0])
prev_start, prev_end = time[0]

for i in range(1, n):
    now_start, now_end = time[i]

    if prev_end <= now_start:
        result.append((now_start, now_end))
        prev_end = now_end
    else:
        continue

print(len(result))