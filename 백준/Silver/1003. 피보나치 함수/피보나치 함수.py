zero = [0] * 41
one = [0] * 41

#DP란 무엇인가...
# 기저 사례 a==1 일 때 zero == 0, one == 1
zero[0] = 1
one[0] = 0
zero[1] = 0
one[1] = 1

# DP 테이블 채우기
for i in range(2, 41):
    zero[i] = zero[i-1] + zero[i-2]
    one[i] = one[i-1] + one[i-2]

n = int(input())

for i in range(n):
    a = int(input())
    print(zero[a], one[a])