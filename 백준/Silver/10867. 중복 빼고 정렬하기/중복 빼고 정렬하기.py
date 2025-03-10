n = int(input())
nlist = set(map(int, input().split()))

nlist = list(nlist)
nlist.sort()

for n in nlist:
    print(n, end=' ')