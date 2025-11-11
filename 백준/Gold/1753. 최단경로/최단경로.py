import heapq
import sys

INF = sys.maxsize
v, e = map(int, input().split())
k = int(input())
dp = [INF] * (v+1)
graph = [[] for _ in range(v+1)]
heap = []

def dijkstra(start):
    # 가중치 테이블에서
    # 시작 정점에 해당하는 가중치는 0으로 초기화
    dp[start] = 0
    heapq.heappush(heap, (0, start))

    #힙에 원소가 없을 때 까지 반복.
    while heap:
        # 가중치, 현재 노드
        wei, now = heapq.heappop(heap)

        # if unnecessary tuple is ignored comparing current table
        if dp[now] < wei:
            continue

        for w, next_node in graph[now]:
            #현재 정점까지의 가중치 wei + 현재 정점에서 다음 정점까지의 가중치 W
            # = to next node weight(next_wei)
            next_wei = w + wei
            # 다음 노드까지의 가중치가 현재 기록된 값 보다 작으면 조건 성립
            if next_wei < dp[next_node]:
                # 계산했던 next_wei를 가중치 테이블에 업뎃
                dp[next_node] = next_wei
                #다음 점 까지의 가중치와 다음 점에 대한 정보를 튜플로 묶어 최소 힙에 삽입
                heapq.heappush(heap, (next_wei, next_node))

for _ in range(e):
    x, y, z = map(int, input().split())
    graph[x].append((z,y))

dijkstra(k)
for i in range(1, v+1):
    print("INF" if dp[i] == INF else dp[i])
