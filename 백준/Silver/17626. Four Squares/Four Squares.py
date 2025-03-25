import sys, math
input = sys.stdin.readline

n = int(input())

a, b, c, d = 0, 0, 0, 0
count = 0
arr = [0] * (50001)

# 제곱수들 미리 할당
for i in range(int(math.sqrt(50001))):
    arr[i**2] = 1

arr[2] = 2
arr[3] = 3

# i보다 작은 제곱수를 빼면서 그 최솟값을 찾아 할당
for i in range(1, n+1):
    min = 4 # 최솟값 4개
    if arr[i] == 0: # 제곱수가 아닐 때,
        for j in range(1, int(math.sqrt(i)+1)): # 1부터 루트 i 까지
            if arr[i-j**2] + 1 < min:
                min = arr[i-j**2] + 1
        arr[i] = min


print(arr[n])