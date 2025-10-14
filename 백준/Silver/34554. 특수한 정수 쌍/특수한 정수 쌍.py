

def prime(a):
    result = True

    for i in range(2, a):
        if a%i == 0:
            result = False
            break

    return result

t = int(input())

for i in range(t):
    n = int(input())
    result = []
    k = 0
    for a in range(1, 1000):

        if prime(a*(n+a)):
            k += 1
            result.append((a, n+a))
        else:
            continue

    print(len(result))
    for a, b in result:
        print(a, b)