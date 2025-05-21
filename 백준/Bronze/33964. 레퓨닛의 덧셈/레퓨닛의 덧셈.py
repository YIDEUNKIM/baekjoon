x, y = map(int, input().split())

s1 = ""
for i in range(x):
    s1 = s1+"1"

s2 = ""
for i in range(y):
    s2 = s2+"1"

print(int(s1)+int(s2))