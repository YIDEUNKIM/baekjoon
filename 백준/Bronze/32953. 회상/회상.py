from collections import defaultdict

n, m = map(int, input().split())
arr = []
student_count = defaultdict(int)

for _ in range(n):
    k = int(input()) 
    group = list(map(int, input().split()))
    for stu in group:
        student_count[stu] += 1
   


result_count = sum(1 for count in student_count.values() if count >= m)
print(result_count)
