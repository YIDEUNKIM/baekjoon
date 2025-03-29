
n, m = map(int, input().split())


s1 = set()
s2 = []
for i in range(n):
    x = input()
    s1.add(x)
    
count = 0
for i in range(m):
    y = input()
    if y in s1:
        count += 1
print(count)