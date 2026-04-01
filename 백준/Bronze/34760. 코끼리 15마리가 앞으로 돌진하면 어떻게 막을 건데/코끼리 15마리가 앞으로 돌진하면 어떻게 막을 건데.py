lst = list(map(int, input().split()))


if lst[len(lst)-1] == max(lst) and lst.count(max(lst)) == 1:
    print(max(lst))
else:
    print(max(lst) + 1)