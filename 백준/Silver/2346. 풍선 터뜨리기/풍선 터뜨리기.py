from collections import deque

n = int(input())

lst = list(map(int, input().split()))

q = deque()

for i in range(1, n+1):
    q.append(i)

index = 0
count1 = 1
count2 = -1
value = q.popleft()
print(value, end=" ") # 맨 왼쪽 1 pop

while len(q) > 1:
    #print(q)
    if lst[index] > 0:
        value = q.popleft()
        if count1 == lst[index]:
            print(value, end=" ")
            index = value-1
            count1 = 1

        else:
            q.append(value)
            count1 += 1

    else:

        value = q.pop()
        if count2 == lst[index]:
            print(value, end=" ")
            index = value-1
            count2 = -1
        else:
            q.appendleft(value)
            count2 -= 1
    #print("value ",value)

print(q.pop(), end="")