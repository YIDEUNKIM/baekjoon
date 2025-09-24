from collections import deque

def dfs(start):
    visited1[start] = True

    print(start, end=' ')

    for i in range(1, n+1):
        if not visited1[i] and matrix[start][i] == 1:
            dfs(i)


def bfs(v):
    q = deque([v])

    visited2[v] = True

    while q:
        v = q.popleft()

        print(v, end=' ')

        for i in range(1, n+1):
            if not visited2[i] and matrix[v][i] == 1:
                q.append(i)
                visited2[i] = True


n, m, v = map(int, input().split())

matrix = [[False]*(n+1) for _ in range(n+1)]
visited1 = [False]*(n+1)
visited2 = [False]*(n+1)

for i in range(m):
    a, b = map(int, input().split())
    matrix[a][b] = 1
    matrix[b][a] = 1

dfs(v)
print()
bfs(v)