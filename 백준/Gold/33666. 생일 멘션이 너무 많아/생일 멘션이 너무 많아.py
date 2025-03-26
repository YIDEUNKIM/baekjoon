import sys

input = sys.stdin.readline
N, M = map(int, input().split())
P = list(map(int, input().split()))

# 1. 평균 계산 (p >= 2만 고려)
mention_sum = 0
mention_count = 0
for p in P:
    if p >= 2:
        mention_sum += p
        mention_count += 1

if mention_count == 0:
    avg = 0
else:
    avg = mention_sum // mention_count

# 2. 매크로 의심 판별: 평균 이하 그룹 중, 2회 이상 보냈는데 p > M인 경우
for p in P:
    if p <= avg and p >= 2 and p > M:
        print(-1)
        sys.exit()

# 3. 누적합으로 메시지 분배
# 메시지 번호는 0 ~ M-1 (실제 출력 시 1번부터 M번)
# 평균 이하 그룹: 각 사람 p에 대해
#   - 모든 메시지에 p//M씩 추가
#   - 그리고 첫 (p % M)개의 메시지에 1씩 추가
# 평균 초과 그룹: 메시지1(인덱스 0)에만 1 추가

# Group A: p > avg, Group B: p <= avg
cntA = 0  # 평균 초과 그룹 인원 수
sumB_full = 0  # 그룹 B에서 각 메시지에 더할 공통 횟수
diff = [0] * (M + 1)  # 차이 배열 (0~M)

for p in P:
    if p > avg:
        cntA += 1
    else:
        sumB_full += (p // M)
        r = p % M
        if r > 0:
            diff[0] += 1
            diff[r] -= 1

# 누적합으로 extra 배열 계산 (0번부터 M-1번까지)
extra = [0] * M
extra[0] = diff[0]
for i in range(1, M):
    extra[i] = extra[i-1] + diff[i]

# 4. 각 메시지별 총 횟수 계산
# 모든 메시지는 그룹B의 공통 횟수 sumB_full를 더하고,
# 각 인덱스에 해당 extra 값을 더함.
# 그리고 메시지1(인덱스 0)에는 그룹A의 횟수도 추가.
result = [sumB_full + extra[i] for i in range(M)]
result[0] += cntA

# 5. 결과 출력
print(" ".join(map(str, result)))
