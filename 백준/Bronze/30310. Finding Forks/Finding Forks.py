t = int(input())

n = list(map(int, input().split()))

n.sort()
result = n[0] + n[1]
print(result)

