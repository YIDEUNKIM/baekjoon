import sys
import math
input = sys.stdin.readline
t = int(input())

for i in range(t):
    n = input()
    n_int = int(n)
    n_reverse = n[::-1]
    n_reverseInt = int(n_reverse)

    if float.is_integer(math.sqrt(n_int)) and float.is_integer(math.sqrt(n_reverseInt)):
        print("YES")
    else:
        print("NO")




