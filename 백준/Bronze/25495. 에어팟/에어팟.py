n = int(input())

phone_nums = list(map(int, input().split()))
result = 2
now = 2
end = False

for i in range(1, n):
    if end:
        end = False
    elif phone_nums[i] == phone_nums[i - 1]:
        now *= 2
    else:
        now = 2

    result += now

    if result >= 100:
        result = 0
        now = 2
        end = True

print(result)