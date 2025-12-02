import heapq
import sys


def dijkstra(start):
    pass

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
for i in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))

distance = [sys.maxsize for _ in range(n+1)]
visited = [False] * (n+1)
start, end = map(int, input().split())
q = []
heapq.heappush(q, (0, start))

def dijkstra(start):
    distance[start] = 0
    while q:
        now_wei, now_v = heapq.heappop(q)
        if not visited[now_v]:
            visited[now_v] = True
            for neighbor, weight in graph[now_v]:
                next_weight = now_wei + weight
                if next_weight < distance[neighbor]:
                    distance[neighbor] = next_weight
                    heapq.heappush(q, (next_weight, neighbor))

dijkstra(start)

print(distance[end])

