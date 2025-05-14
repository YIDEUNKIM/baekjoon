n = int(input())

p = [[0,0,0], [0,0,1], [0,1,0], [0,1,1], [1,0,0], [1,0,1], [1,1,0], [1,1,1]]

for i in range(n):
    case = list(map(int, input().split()))

    if (case[0] in [0, 1, 2, 3]) and (case[1] in [0, 1, 2, 3]) and (case[2] in [0, 1, 2, 3]) and (case[3] in [0, 1, 2, 3]):
        print("YES")
    elif (case[0] in [0, 1, 5, 4]) and (case[1] in [0, 1, 5, 4]) and (case[2] in [0, 1, 5, 4]) and (case[3] in [0, 1, 5, 4]):
        print("YES")
    elif (case[0] in [1, 3, 5, 7]) and (case[1] in [1, 3, 5, 7]) and (case[2] in [1, 3, 5, 7]) and (case[3] in [1, 3, 5, 7]):
        print("YES")
    elif (case[0] in [2, 3, 6, 7]) and (case[1] in [2, 3, 6, 7]) and (case[2] in [2, 3, 6, 7]) and (case[3] in [2, 3, 6, 7]):
        print("YES")
    elif (case[0] in [0, 2, 4, 6]) and (case[1] in [0, 2, 4, 6]) and (case[2] in [0, 2, 4, 6]) and (case[3] in [0, 2, 4, 6]):
        print("YES")
    elif (case[0] in [4, 5, 6, 7]) and (case[1] in [4, 5, 6, 7]) and (case[2] in [4, 5, 6, 7]) and (case[3] in [4, 5, 6, 7]):
        print("YES")
    else:
        print("NO")