from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(tomato):

    q = deque(tomato)

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<m and 0<=ny<n:
                if graph[nx][ny] == 0:
                    graph[nx][ny] = graph[x][y] + 1
                    q.append((nx, ny))

n, m = map(int, input().split())
graph = []
for i in range(m):
    graph.append(list(map(int, input().split())))

answer = 0
cnt = 0
trigger = 0
tomato = []
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            tomato.append((i,j))
            cnt += 1

bfs(tomato)
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
           trigger = 1

if cnt == n*m:
    print(0)
elif trigger == 1:
    print(-1)
else:
    ans = 0
    for row in graph:
        ans = max(ans, max(row))
    print(ans - 1)