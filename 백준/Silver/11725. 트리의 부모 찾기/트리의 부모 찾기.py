from collections import deque
import sys

input = sys.stdin.readline


def bfs(tree, start):
    q = deque([start])
    visited[start] = True
    answer = [0] * (n + 1)

    while q:
        v = q.popleft()

        for neighbor in tree[v]:  # 연결된 노드만 확인
            if not visited[neighbor]:
                answer[neighbor] = v
                q.append(neighbor)
                visited[neighbor] = True

    return answer


n = int(input())

tree = [[] for _ in range(n + 1)]  # 인접 리스트

for _ in range(n - 1):
    x, y = map(int, input().split())
    tree[x].append(y)
    tree[y].append(x)

visited = [False] * (n + 1)

answer = bfs(tree, 1)

for i in range(2, n + 1):
    print(answer[i])