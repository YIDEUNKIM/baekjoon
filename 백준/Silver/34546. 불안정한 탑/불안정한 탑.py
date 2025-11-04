n = int(input())
towers = list(map(int, input().split()))

min_height = min(towers)
total_cost = sum(h - min_height for h in towers)

print(total_cost)