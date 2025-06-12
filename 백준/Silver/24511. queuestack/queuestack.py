from collections import deque

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
M = int(input())
C = list(map(int, input().split()))

# 큐들만 역순으로 연결
queue_elements = deque()
for i in range(N-1, -1, -1):
    if A[i] == 0:  # 큐인 경우만
        queue_elements.append(B[i])

# 결과 계산
result = []
for c in C:
    if queue_elements:
        result.append(queue_elements.popleft())
        queue_elements.append(c)
    else:
        result.append(c)

print(*result)