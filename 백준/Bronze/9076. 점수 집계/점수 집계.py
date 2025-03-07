
t = int(input())

for i in range(t):
    w = list(map(int, input().split()))
    w.sort()

    if(abs(w[1]-w[2]) >= 4):
        print("KIN")

    elif(abs(w[2]-w[3]) >= 4):
        print("KIN")

    elif(abs(w[1]-w[3]) >= 4):
        print("KIN")
    else:
        print(w[1] + w[2] + w[3])

    w.clear()