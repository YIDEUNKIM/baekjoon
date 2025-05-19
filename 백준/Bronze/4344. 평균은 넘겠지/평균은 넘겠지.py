n = int(input())

for i in range(n):
    case = list(map(int, input().split()))

    scores = case[1:]

    average = sum(scores) / case[0]

    numbers = 0
    for score in scores:  # case[1:] 사용
        if score > average:
            numbers += 1
    result = (numbers / case[0]) * 100
    print(f"{result:.3f}%")