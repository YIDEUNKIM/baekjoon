from collections import deque
import sys

input = sys.stdin.readline


def dfs(number):
    visited[number] = True
    cnode = 0

    for i in tree[number]:
        if not visited[i] and i != deleted_node:
            cnode += 1
            dfs(i)

    if cnode == 0:
        ans[0] += 1


n = int(input())

tree = [[] for _ in range(n)]
lst = list(map(int, input().split()))

for i in range(n):
    if lst[i] != -1:
        tree[lst[i]].append(i)  # 부모 -> 자식만 저장
    else:
        root = i

deleted_node = int(input())
visited = [False] * n  # 전역으로 선언
ans = [0]

if deleted_node == root:
    print(0)
else:
    dfs(root)
    print(ans[0])