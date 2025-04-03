n, d, k = map(int, input().split())
# n개의 점, d일동안, 별이 k개 초과
s = list(map(int, input().split()))

value = max(s) # s의 최댓값 할당
count = 0 # 결과값 카운팅
f = [0 for _ in range(n)] f 초기화



for i in range(d): # d일 동안 순회

    if max(f)+ value > k: # s의 최댓값 + 그 다음날 더해질 별의 갯수 > k 일때 count = count + 1
        f = [0 for _ in range(n)]
        count += 1
    
    for j in range(n):
        f[j] += s[j] # 다음날로 넘어갈 때 별 쌓임


print(count) # 결과 출력
