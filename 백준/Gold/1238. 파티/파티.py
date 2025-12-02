import heapq
import sys

n, m, x = map(int, input().split())

graph = [[] for _ in range(n+1)]
for i in range(m):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

def dijkstra(start):
    distance = [sys.maxsize for _ in range(n + 1)]
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        now_wei, now_v = heapq.heappop(q)

        if distance[now_v] < now_wei:
            continue

        for neighbor, weight in graph[now_v]:
            cost = now_wei + weight
            if cost < distance[neighbor]:
                distance[neighbor] = cost
                heapq.heappush(q, (cost, neighbor))
    return distance

result = 0

for i in range(1, n+1):
    go = dijkstra(i)
    back = dijkstra(x)

    result = max(result, go[x] + back[i])

print(result)