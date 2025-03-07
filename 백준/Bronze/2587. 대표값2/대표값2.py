#t = int(input())

n = []
for i in range(5):
    n.append(int(input()))

n.sort()

print(int(sum(n)/len(n)))
print(n[2])