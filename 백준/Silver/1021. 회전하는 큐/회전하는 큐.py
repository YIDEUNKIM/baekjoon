from collections import deque

n, m = map(int, input().split())

q = deque(i for i in range(1, n+1))

lst = list(map(int, input().split()))

cnt = 0

for i in lst:
    while True:
        if q[0] == i:
            q.popleft() # 1번 연산
            break
        else:
            if q.index(i) < (len(q)) / 2:
                while q[0] != i: # 위치가 왼쪽에 있을 때 2번 연산
                    q.append(q.popleft())
                    cnt += 1
            else:
                while q[0] != i: # 위치가 오른쪽에 있을 때 3번 연산
                    q.appendleft(q.pop())
                    cnt += 1

print(cnt)