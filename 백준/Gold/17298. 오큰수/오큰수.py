# 오큰수



import sys
input = sys.stdin.readline
n = int(input())

a = list(map(int, input().split()))

stack = []
stack.append(0)
ans = [0] * n

for i in range(n):
    while(stack and a[i] > a[stack[-1]]):
        ans[stack.pop()] = a[i]
    stack.append(i)

while(stack):
    ans[stack.pop()] = -1

for i in range(n):
    print(str(ans[i]), end=" ")
