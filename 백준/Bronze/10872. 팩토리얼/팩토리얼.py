n = int(input())
lst = [x for x in range(1, n+1)]
sum = 1
for i in lst:
    sum *= i

print(sum)