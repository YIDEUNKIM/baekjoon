from collections import deque


def bfs(graph, visited):
    infections = 0
    first = 1
    queue = deque([first])
    visited[1] = True
    while queue:
        current = queue.popleft() # 현재 노드 반환
        for neighbor in graph[current]:
            if not visited[neighbor]: # 방문하지 않았다면
                visited[neighbor] = True
                queue.append(neighbor)
                infections += 1


    return infections


t = int(input())
n = int(input())

graph = [[] for _ in range(t+1)]
visited = [False] * (t+1)

for i in range(n):
    p, q = map(int, input().split())
    graph[p].append(q)
    graph[q].append(p)

result = bfs(graph, visited)
print(result)
