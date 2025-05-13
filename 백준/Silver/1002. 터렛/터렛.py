import math
n = int(input())

for a in range(n):
    point = list(map(int, input().split()))
    x1, y1, r1, x2, y2, r2 = point
    
    # 두 점 사이의 거리 계산
    distance = math.sqrt((x2-x1)**2 + (y2-y1)**2)
    
    # 두 원이 동일한 경우
    if x1 == x2 and y1 == y2 and r1 == r2:
        print("-1")
    else:
        # 두 원의 관계 판단
        if distance > r1 + r2:  # 두 원이 떨어져 있는 경우
            print("0")
        elif distance < abs(r1 - r2):  # 한 원이 다른 원 내부에 있는 경우
            print("0")
        elif distance == r1 + r2:  # 외접하는 경우
            print("1")
        elif distance == abs(r1 - r2):  # 내접하는 경우
            print("1")
        else:  # 두 점에서 만나는 경우
            print("2")