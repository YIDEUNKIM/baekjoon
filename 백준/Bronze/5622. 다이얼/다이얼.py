import re
m = input()

sum = 0
for i in m:
    
    if re.match(r'^[A-C]$', i):
       sum +=  3
    elif re.match(r'^[D-F]$', i):
        sum += 4
    elif re.match(r'^[G-I]$', i):
        sum += 5
    elif re.match(r'^[J-L]$', i):
        sum += 6
    elif re.match(r'^[M-O]$', i):
        sum += 7
    elif re.match(r'^[P-S]$', i):
        sum += 8
    elif re.match(r'^[T-V]$', i):
        sum += 9
    elif re.match(r'^[W-Z]$', i):
        sum += 10


print(sum)