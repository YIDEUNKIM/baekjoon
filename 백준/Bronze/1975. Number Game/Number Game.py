def v_b(n, b):
    if n==0:
        return float('inf')

    count = 0
    while n%b == 0:
        n //= b
        count += 1

    return count

def s_k(n, k):
    return sum(v_b(n, b) for b in range(2, k + 1))

t = int(input())
for i in range(t):
    n = int(input())
    print(s_k(n, n))