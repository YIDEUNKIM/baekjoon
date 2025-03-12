r, k, m = map(int, input().split())

cycle = m // k
result = r // (2 ** cycle)

print(result)
