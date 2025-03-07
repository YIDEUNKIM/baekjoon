n = int(input())
nlist = list(map(int, input().split()))
mlist = list(map(int, input().split()))

nlist.sort()
mlist.sort(reverse=True)

s = 0
for i in range(n):
    s += nlist[i] * mlist[i]

print(s)