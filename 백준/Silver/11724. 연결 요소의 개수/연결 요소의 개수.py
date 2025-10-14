from collections import deque

def bfs(start):
    q = deque([start])
    visited[start] = True

    while q:
        v = q.popleft()

        for i in range(N+1):
            if not visited[i] and matrix[v][i] == 1:
                q.append(i)
                visited[i] = True

N, M = map(int, input().split())
matrix = [[0]*(N+1) for _ in range(N+1)]

visited = [False] * (N+1)
for i in range(M):
    x, y = map(int, input().split())
    matrix[x][y] = matrix[y][x] = 1

result = 0
for i in range(1, N+1):
    if not visited[i]:
        bfs(i)
        result += 1

print(result)
