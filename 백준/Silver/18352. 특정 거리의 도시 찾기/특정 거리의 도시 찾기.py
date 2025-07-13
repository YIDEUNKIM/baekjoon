from collections import deque
import sys

def solve():
    n, m, k, x = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())
        graph[a].append(b)

    distances = [-1] * (n + 1)
    distances[x] = 0
    queue = deque([x])
    results = []

    while queue:
        node = queue.popleft()

        if distances[node] == k:
            results.append(node)
            continue

        for neighbor in graph[node]:
            if distances[neighbor] == -1:
                distances[neighbor] = distances[node] + 1
                queue.append(neighbor)


    if not results:
        print(-1)
    else:
        results.sort()
        for city in results:
            print(city)

solve()