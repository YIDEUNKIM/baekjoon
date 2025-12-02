# 최단 경로
import heapq
import sys

INF = sys.maxsize

v, e = map(int, input().split())
k = int(input())

graph = [[] for _ in range(v+1)]
mdistance = [INF for _ in range(v+1)]
q = []
heapq.heappush(q, (0, k))
visited = [False]* (v+1)
mdistance[k] = 0

for i in range(e):
    x, y, z = map(int, input().split())
    graph[x].append((y,z))

while q:
    w, v = heapq.heappop(q)

    if not visited[v]:
        visited[v] = True
        for neighbor, weight in graph[v]:
            next_wei = w + weight
            if next_wei < mdistance[neighbor]:
                mdistance[neighbor] = next_wei
                heapq.heappush(q, (next_wei, neighbor))


for i in range(1, len(mdistance)):
    if mdistance[i]==INF:
        print("INF")
    else:
        print(mdistance[i])