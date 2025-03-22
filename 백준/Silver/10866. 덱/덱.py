from collections import deque

n = int(input())

dq = deque()
for i in range(n):
    k = list(map(str, input().split()))

    if k[0] == "push_back":
        dq.append(k[1])
    elif k[0] == "push_front":
        dq.appendleft(k[1])
    elif k[0] == "pop_front":
        print(dq.popleft() if len(dq) != 0 else -1)
    elif k[0] == "pop_back":
        print(dq.pop() if len(dq) != 0 else -1)
    elif k[0] == "size":
        print(len(dq))
    elif k[0] == "empty":
        print(1 if len(dq) == 0 else 0)
    elif k[0] == "front":
        print(dq[0] if len(dq) != 0 else -1)
    elif k[0] == "back":
        print(dq[-1] if len(dq) != 0 else -1)
    else:
        pass
