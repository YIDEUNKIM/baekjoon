from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

stack = deque()
for i in range(n):
    command = list(map(str, input().split()))

    if command[0] == "1":
        stack.appendleft(command[1])
    elif command[0] == "2":
        print(stack.popleft() if len(stack) != 0 else -1)
    elif command[0] == "3":
        print(len(stack))
    elif command[0] == "4":
        print(0 if len(stack) != 0 else 1)
    elif command[0] == "5":
        print(stack[0] if len(stack) != 0 else -1)