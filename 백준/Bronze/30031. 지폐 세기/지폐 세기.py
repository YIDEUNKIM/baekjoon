n = int(input())

chun = "136"
ochun = "142"
man = "148"
oman = "154"

summation = 0
for i in range(n):
    a, b = map(int, input().split())
    if a == 136:
        summation += 1000
    elif a == 142:
        summation += 5000
    elif a == 148:
        summation += 10000
    elif a == 154:
        summation += 50000

print(summation)