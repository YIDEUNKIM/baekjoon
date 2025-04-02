n, d, k = map(int, input().split())
# n개의 점, d일동안, 별이 k개 초과
s = list(map(int, input().split()))

value = max(s)
count = 0
f = [0 for _ in range(n)]



for i in range(d):

    if max(f)+ value > k:
        f = [0 for _ in range(n)]
        count += 1
    
    for j in range(n):
        f[j] += s[j]


print(count)