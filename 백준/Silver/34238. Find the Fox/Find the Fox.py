n, m = map(int, input().split())

delta = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # 상하좌우
delta_da = [(1, 1), (1, -1), (-1, 1), (-1, -1)]  # 대각선

lst = []
for i in range(n):
    s = list(input())
    lst.append(s)

result1 = 0  # 상하좌우 FOX 개수
result2 = 0  # 대각선 FOX 개수

for i in range(n):
    for j in range(m):
        if lst[i][j] == 'F':
            # 상하좌우 방향 검사
            for dr, dc in delta:
                # O의 위치
                o_row = i + dr
                o_col = j + dc

                # X의 위치 (같은 방향으로 한 칸 더)
                x_row = i + dr * 2
                x_col = j + dc * 2

                # 경계 체크
                if 0 <= o_row < n and 0 <= o_col < m and \
                        0 <= x_row < n and 0 <= x_col < m:
                    if lst[o_row][o_col] == 'O' and lst[x_row][x_col] == 'X':
                        result1 += 1

            # 대각선 방향 검사
            for dr, dc in delta_da:
                # O의 위치
                o_row = i + dr
                o_col = j + dc

                # X의 위치 (같은 방향으로 한 칸 더)
                x_row = i + dr * 2
                x_col = j + dc * 2

                # 경계 체크
                if 0 <= o_row < n and 0 <= o_col < m and \
                        0 <= x_row < n and 0 <= x_col < m:
                    if lst[o_row][o_col] == 'O' and lst[x_row][x_col] == 'X':
                        result2 += 1

print(result1+result2)