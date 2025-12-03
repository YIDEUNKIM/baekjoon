import sys
sys.setrecursionlimit(100000)
def union(a, b):
    a = find(a) # a의 부모 노드 찾기
    b = find(b) # b의 부모 노드 찾기

    if a<=b:
        nodes[b] = a # 같은 size이면 더 낮은 index를 대표노드로 함
    else:
        nodes[a] = b

def find(x):
    if x != nodes[x]:
        nodes[x] = find(nodes[x]) # 재귀적으로 부모 노드를 찾음

    return nodes[x]


v, e = map(int, input().split())

matrix = []
nodes = [i for i in range(v+1)]

for i in range(e):
    a, b, c = map(int, input().split())

    matrix.append((c, a, b))

matrix.sort()

answer = 0
for cost, a, b in matrix:
    if not find(a) == find(b): # a, b가 같지 않다면
        union(a, b) # 합
        answer += cost # cost

print(answer)