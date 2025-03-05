p, n = map(int, input().split())

sequences = list(map(int, input().split()))

sequences.sort()

cnt = 0
for a in sequences:
    if p < 200:
       cnt += 1
       p = p + a
       
    else:
        pass

print(cnt)