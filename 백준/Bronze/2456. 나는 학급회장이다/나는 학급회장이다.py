import sys

N = int(sys.stdin.readline())
candidates = [[0, 0, 0, i + 1] for i in range(3)]

for _ in range(N):
    scores = list(map(int, sys.stdin.readline().split()))
    for i in range(3):
        candidates[i][0] += scores[i]          
        if scores[i] == 3: candidates[i][1] += 1 
        elif scores[i] == 2: candidates[i][2] += 1

# 비교 기준(총점, 3점, 2점)에 따라 내림차순 정렬
# 정렬을 하면 첫 번째 요소(index 0)가 자동으로 1위가 됨
candidates.sort(key=lambda x: (x[0], x[1], x[2]), reverse=True)

# 1위와 2위의 '비교 기준 3종 세트'가 완전히 같은지 확인
if candidates[0][0:3] == candidates[1][0:3]:
    print(0, candidates[0][0])
else:
    print(candidates[0][3], candidates[0][0])