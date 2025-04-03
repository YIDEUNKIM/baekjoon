import sys
from collections import defaultdict, deque

def min_days_and_water(N):
    if N == 0:
        return 0, 0  # 초기 길이가 이미 목표와 같음
    
    # 각 길이에 대한 (최소 일수, 최소 물)을 저장하는 딕셔너리
    min_days = {}
    min_water = {}
    min_days[0] = 0
    min_water[0] = 0
    
    # BFS를 위한 큐: (길이, 일수, 물의 양)
    queue = deque([(0, 0, 0)])
    
    while queue:
        length, days, water = queue.popleft()
        
        # 현재 상태가 더 이상 최적이 아닌 경우 건너뜀
        if days > min_days.get(length, float('inf')) or (days == min_days.get(length, float('inf')) and water > min_water.get(length, float('inf'))):
            continue
        
        next_days = days + 1
        
        # 1. 물을 1만큼 주는 경우 (길이 + 1)
        new_length = length + 1
        new_water = water + 1
        
        if new_length <= N:
            if (new_length not in min_days or next_days < min_days[new_length] or 
                (next_days == min_days[new_length] and new_water < min_water[new_length])):
                min_days[new_length] = next_days
                min_water[new_length] = new_water
                queue.append((new_length, next_days, new_water))
        
        # 2. 물을 3만큼 주는 경우 (길이 * 3)
        new_length = length * 3
        new_water = water + 3
        
        if new_length <= N:
            if (new_length not in min_days or next_days < min_days[new_length] or 
                (next_days == min_days[new_length] and new_water < min_water[new_length])):
                min_days[new_length] = next_days
                min_water[new_length] = new_water
                queue.append((new_length, next_days, new_water))
        
        # 3. 물을 5만큼 주는 경우 (길이 ^ 2)
        if length > 1:  # 길이가 0 또는 1이면 제곱해도 도움이 안됨
            new_length = length * length
            new_water = water + 5
            
            if new_length <= N:
                if (new_length not in min_days or next_days < min_days[new_length] or 
                    (next_days == min_days[new_length] and new_water < min_water[new_length])):
                    min_days[new_length] = next_days
                    min_water[new_length] = new_water
                    queue.append((new_length, next_days, new_water))
    
    return min_days[N], min_water[N]

def main():
    N = int(sys.stdin.readline().strip())
    days, water = min_days_and_water(N)
    print(days, water)

if __name__ == "__main__":
    main()