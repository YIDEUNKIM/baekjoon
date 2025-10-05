n = int(input())

Tn = [i*(i+1)/2 for i in range(1, 46)]
for i in range(n):
    result = 0
    sam = int(input())
    for j in range(45):
        for k in range(45):
            for p in range(45):
                if Tn[j] + Tn[k] + Tn[p] == sam:
                    result = 1
                    break


    print(result)

