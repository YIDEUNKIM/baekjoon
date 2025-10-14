M = list(map(int, input().split()))
N = int(input())

B = []
L = []
S = []

for i in range(N):
    a, b, c = map(float, input().split())
    B.append(a)
    L.append(b)
    S.append(c)

result = 0
for i in range(N):
    if S[i] >= 17 and L[i] >= 2.0:
        result += M[int(B[i])]

print(result)