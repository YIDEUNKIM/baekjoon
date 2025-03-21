import math

n = int(input())

count = 0
result = 0
i=1

while True:
    if n < count:
        print(result-1)
        break
    count += i
    i += 1
    result += 1