from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

discuss = []

for i in range(n):
    start, end = map(int, input().split())
    discuss.append([start, end])

discuss = sorted(discuss, key=lambda x: (x[1], x[0]))

count = 0
endpoint = 0

for start, end in discuss:
    if endpoint <= start:
        count += 1
        endpoint = end

print(count)

