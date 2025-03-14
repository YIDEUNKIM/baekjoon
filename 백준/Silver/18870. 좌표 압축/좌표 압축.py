import sys
t = int(sys.stdin.readline().rstrip())

n = list(map(int, sys.stdin.readline().rstrip().split()))

s = set(n)
new_n = list(s)
new_n.sort()

dic = {}

for i in range(len(new_n)):
    dic[new_n[i]]= i

for i in n:
    print(dic.get(i), end=' ')