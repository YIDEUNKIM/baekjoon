import copy

n, m = map(int, input().split())
k = int(input())
skills = list(input())

burgers = [[1, 2],[3, 4],[5, 6],[7, 8]]
f = burgers[n-1][m-1]

for i in skills:
    tmp = [row[:] for row in burgers]
    if i=='A':
        burgers[0] = tmp[2]
        burgers[1] = tmp[3]
        burgers[2] = tmp[0]
        burgers[3] = tmp[1]

    elif i == 'B':
        burgers[0][0] = tmp[1][1]
        burgers[1][1] = tmp[0][0]

        burgers[0][1] = tmp[1][0]
        burgers[1][0] = tmp[0][1]

        burgers[2][0] = tmp[3][1]
        burgers[3][1] = tmp[2][0]

        burgers[2][1] = tmp[3][0]
        burgers[3][0] = tmp[2][1]
    elif i == 'C':
        burgers[0][0] = tmp[3][1]
        burgers[3][1] = tmp[0][0]

        burgers[1][0] = tmp[2][1]
        burgers[2][1] = tmp[1][0]

        burgers[1][1] = tmp[2][0]
        burgers[2][0] = tmp[1][1]

        burgers[0][1] = tmp[3][0]
        burgers[3][0] = tmp[0][1]
        
    elif i == 'D':
        burgers[0][1] = tmp[0][0]
        burgers[1][1] = tmp[0][1]
        burgers[2][1] = tmp[1][1]
        burgers[3][1] = tmp[2][1]

        burgers[3][0] = tmp[3][1]
        burgers[2][0] = tmp[3][0]
        burgers[1][0] = tmp[2][0]
        burgers[0][0] = tmp[1][0]
        
for i in range(4):
    for j in range(2):
        if f == burgers[i][j]:
            print(i+1, j+1)