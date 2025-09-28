S, P = map(int, input().split())
dna = (input())
ACGT = list(map(int, input().split()))

cnt = 0

s = 0 # 문자열 시작 포인터
e = P # 부분 문자열의 끝 포인터

check = [0] * 4
check[0] = dna[s : e].count('A')
check[1] = dna[s : e].count('C')
check[2] = dna[s : e].count('G')
check[3] = dna[s : e].count('T')
# dna의 각 A C G T 개수 세기

while True:
    cnt += 1
    for i in range(4):
        if ACGT[i] > check[i]:
            cnt -= 1
            break
            # A C G T 중 하나라도 개수 미달이면 탈락
    if e >= S:
        break

    if dna[s] == 'A':
        check[0] -= 1
    elif dna[s] == 'C':
        check[1] -= 1
    elif dna[s] == 'G':
        check[2] -= 1
    elif dna[s] == 'T':
        check[3] -= 1

    s += 1

    if dna[e] == 'A':
        check[0] += 1
    elif dna[e] == 'C':
        check[1] += 1
    elif dna[e] == 'G':
        check[2] += 1
    elif dna[e] == 'T':
        check[3] += 1
    e += 1

print(cnt)

