from collections import deque
import sys

input = sys.stdin.readline
def find(x):
    if x != nodes[x]:
        nodes[x] = find(nodes[x])

    return nodes[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        nodes[b] = a
    else:
        nodes[a] = b

n, m = map(int, input().split())
trueP = list(map(int, input().split()))
T = trueP[0]
del trueP[0]
result = 0
party = [[] for _ in range(m)]
nodes = [i for i in range(n+1)]

for i in range(m):
    party[i] = list(map(int, input().split()))
    del party[i][0]

parent = [0] *(n+1)
for i in range(n+1):
    parent[i] = i

for i in range(m):
    firstPeople = party[i][0]
    for j in range(1, len(party[i])):
        union(firstPeople, party[i][j])

for i in range(m):
    isPossible = True
    cur = party[i][0]
    for j in range(len(trueP)):
        if find(cur) == find(trueP[j]):
            isPossible = False
            break
    if isPossible:
        result += 1
        
print(result)