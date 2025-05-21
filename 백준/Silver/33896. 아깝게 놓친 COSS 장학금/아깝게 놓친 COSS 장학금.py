import math

n = int(input())
result = [[] for i in range(n)]


for i in range(n):
    name, score, risk, cost = map(str, input().split())
    score = int(score)
    risk = int(risk)
    cost = int(cost)

    value = math.floor(score**3 / (cost * (risk+1)))
    result[i] = [name, value, cost]

result.sort(key=lambda x : x[1], reverse = True)

for j in range(n):
    for i in range(n-1):
        if result[i][1] == result[i+1][1]:
            if result[i][2] > result[i+1][2]:
                tmp = result[i]
                result[i] = result[i+1]
                result[i+1] = tmp
            elif result[i][2] == result[i+1][2]:
                if (result[i][0]) > (result[i+1][0]):
                    tmp = result[i]
                    result[i] = result[i + 1]
                    result[i + 1] = tmp

print(result[1][0])
