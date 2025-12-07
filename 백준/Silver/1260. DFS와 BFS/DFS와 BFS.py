from collections import deque
import sys
input = sys.stdin.readline

def dfs(start):
    visited[start] = True
    print(start, end=" ")
    for neighbor in graph[start]:
        if not visited[neighbor]:
            dfs(neighbor)

def bfs(start):
    q = deque([start])
    visited[start] = True

    while q:
        node = q.popleft()

        print(node, end=" ")
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                q.append(neighbor)



n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(1, n+1):
    graph[i].sort()

visited = [False]*(n+1)
dfs(v)
print()
visited = [False]*(n+1)
bfs(v)