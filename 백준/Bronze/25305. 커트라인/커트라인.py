
n, k = map(int, input().split())

i = list(map(int, input().split()))

i.sort(reverse=True)

print(i[k-1])
