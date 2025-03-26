b, n, m = map(int, input().split())

items = {}
for i in range(n):
    item = list(map(str, input().split()))
    items[item[0]] = int(item[1])


sum = 0
for i in range(m):
    want = input()
    for i in items.keys():
        if i == want:
            sum += items[want]

if sum > b:
    print("unacceptable")
else:
    print("acceptable")