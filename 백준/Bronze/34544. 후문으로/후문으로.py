n = int(input())
current = 1

for _ in range(n):
    a, b = map(int, input().split())

    # 음수면 +1 보정
    real_a = a + 1 if a < 0 else a
    real_b = b + 1 if b < 0 else b

    current += (real_b - real_a)

# 0층이 없으므로 결과 보정
if current <= 0:
    current -= 1

print(current)