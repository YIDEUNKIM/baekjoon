from collections import deque

i = int(input())

numbers = list(map(int, input().split()))

q = deque()
stack = []
target = 1
for number in numbers:
    if (number == target):
        target += 1

        while stack and stack[-1] == target:
            stack.pop()
            target += 1

    else:
        stack.append(number)

while stack and stack[-1] == target:
    stack.pop()
    target += 1

if stack:
    print("Sad")
else:
    print("Nice")