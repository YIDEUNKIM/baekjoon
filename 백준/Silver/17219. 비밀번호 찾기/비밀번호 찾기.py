n, k = map(int, input().split())
a = {}
a_set = set()
b = set()
for i in range(n):
    str1 = input().split()
    a.update({str1[0]: str1[1]})

for i in range(k):
    str2 = input()
    print(a.get(str2) if str2 in a else 0)

