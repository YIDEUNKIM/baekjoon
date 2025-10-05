m, n = map(int, input().split())

matrix = [[0  for _ in range(m+1)] for _ in range(m+1)]
dx = [1, -1]
dy = [1, -1]

pos = [0, 0]
direction = 0

invalid = 0

for i in range(n):
    commend, value = map(str, input().split())
    value = int(value)
    if commend == "MOVE":
        if direction == 0: # 동쪽
            pos[0] += value * dx[0]
        elif direction == 1: # 북쪽
            pos[1] += value * dy[0]
        elif direction == 2: # 서쪽
            pos[0] += value * dx[1]
        elif direction == 3: # 남쪽
            pos[1] += value * dy[1]

        if pos[0] > m or pos[0] < 0:
            invalid = -1
        elif pos[1] > m or pos[1] < 0:
            invalid = -1
    else:
        if value == 0:
            direction = (direction + 1) % 4
        else:
            direction = (direction - 1) % 4

if invalid == -1:
    print(invalid)
else:
    print(pos[0], pos[1])