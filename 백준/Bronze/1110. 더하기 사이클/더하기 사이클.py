import math

n = int(input())

count = 0

if n<10:
    n = n*10
    origin = n
    while True:
        n1 = origin//10
        n2 = origin%10
        n3 = n1+n2
        origin =  n2*10 + (n3%10)
        count += 1
        if origin == n:
            break
else:
    origin = n
    while True:
        n1 = origin // 10
        n2 = origin % 10
        n3 = n1 + n2
        origin = n2*10 + (n3 % 10)
        count += 1

        if origin == n:
            break
print(count)