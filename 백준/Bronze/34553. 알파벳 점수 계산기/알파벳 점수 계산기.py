s = input()
result = 1
summ = 1
for i in range(len(s)-1):
    if s[i] < s[i+1]:
        result = result+1
        summ = summ + result
    else:
        result = 1
        summ += 1

print(summ)