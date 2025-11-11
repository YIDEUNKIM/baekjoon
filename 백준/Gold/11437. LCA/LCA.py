from collections import deque

def bfs(start):
    visited[start] = True
    q = deque([start])
    level = 1
    cnt = 0
    now_size = 1
    while q:

        v = q.popleft()

        for neighbor in matrix[v]:
            if not visited[neighbor]:
                q.append(neighbor)
                visited[neighbor] = True
                parent[neighbor] = v
                depth[neighbor] = level

        cnt+=1
        if (cnt == now_size):
            cnt = 0
            now_size = len(q)
            level += 1


def excutelca(a, b):
    if (depth[a] < depth[b]):
        tmp = a
        a = b
        b = tmp

    while(depth[a] != depth[b]): # 두 노드의 depth 맞춰주기?
        a = parent[a]

    while (a != b):
        a = parent[a]
        b = parent[b]

    return a

n = int(input())

depth = [0 for _ in range(n+1)]
parent = [0 for _ in range(n+1)]
matrix = [[] for i in range(n+1)]
for i in range(n-1):
    x, y = map(int, input().split())
    matrix[x].append(y)
    matrix[y].append(x)

visited = [False] * (n+1)
bfs(1)
m = int(input())

for i in range(m):
    a, b = map(int, input().split())
    lca = excutelca(a, b)
    print(lca)