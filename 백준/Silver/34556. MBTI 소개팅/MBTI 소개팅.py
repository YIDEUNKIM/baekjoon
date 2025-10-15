from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
men = []
women = []
for i in range(n):
    men.append(input())
for i in range(n):
    women.append(input())

match = [[0] * n for _ in range(n)]

for i in range(n):
    man = men[i]
    for j in range(n):
        woman = women[j]
        for k in range(4):
            if man[k] != woman[k]:
                match[i][j] += 1


visited_women = [False] * n
max_total_score = 0

def backtrack(man_idx, current_score):
    global max_total_score
            
    if man_idx == n:
        if current_score > max_total_score:
            max_total_score = current_score
        return
            
    for woman_idx in range(n):
        if not visited_women[woman_idx]:
            visited_women[woman_idx] = True
            
            new_score = current_score + match[man_idx][woman_idx]
            backtrack(man_idx + 1, new_score)
            
            visited_women[woman_idx] = False
            
backtrack(0,0)
print(max_total_score)