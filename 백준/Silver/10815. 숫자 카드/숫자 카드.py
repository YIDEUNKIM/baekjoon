n = int(input())
nlist = set(map(int, input().split()))

m = int(input())
mlist = list(map(int, input().split()))


result = []

for i in mlist:
    if nlist.__contains__(i):
        result.append("1")

    else:
        result.append("0")

print(" ".join(result))