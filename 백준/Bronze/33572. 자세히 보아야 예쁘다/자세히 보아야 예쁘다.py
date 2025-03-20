import sys

input = sys.stdin.readline

n, m = map(int, input().split())
lst = list(map(int, input().split()))

sum_list = sum(lst)-n

if sum_list < m:
    print("OUT")

else:
    print("DIMI")
