n, m = map(int, input().split())

A, B = map(str, input().split())

stroke = {'A':3,'B':2,'C':1,'D':2,'E':4,'F':3,'G':1,'H':3,
          'I':1,'J':1,'K':3,'L':1,'M':3,'N':2,'O':1,'P':2,
          'Q':2,'R':2,'S':1,'T':2,'U':1,'V':1,'W':1,'X':2,'Y':2,'Z':1}


mixed = ""
for i in range(min(len(A), len(B))):
    mixed += A[i] + B[i]

mixed += A[min(n,m):] + B[min(n,m):]

nums = [stroke[c] for c in mixed]

while len(nums)>2:
    new_nums = []
    for i in range(len(nums)-1):
        total = (nums[i] + nums[i+1]) % 10
        new_nums.append(total)

    nums = new_nums

print(f"{nums[0]*10+nums[1]}%")