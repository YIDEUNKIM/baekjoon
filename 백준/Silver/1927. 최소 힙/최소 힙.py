import heapq
import sys
input = sys.stdin.readline
t = int(input())

heap = []

for i in range(t):
    x = int(input())
    if x == 0:
        if len(heap) != 0:
            print(heap[0])
            heapq.heappop(heap)
        else:
            print(0)
    else:
        heapq.heappush(heap, x)

