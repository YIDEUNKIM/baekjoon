import sys

def post_order_without_recursion(preorder):
    if not preorder:
        return
    
    # 스택을 사용한 반복적 접근법
    # (start, end, is_print) 형태의 튜플을 스택에 저장
    stack = [(0, len(preorder) - 1, False)]
    
    while stack:
        start, end, is_print = stack.pop()
        
        if start > end:
            continue
        
        if is_print:
            # 현재 노드(루트) 출력
            sys.stdout.write(str(preorder[start]) + '\n')
            continue
        
        root = preorder[start]
        
        # 루트보다 큰 첫 번째 원소 위치 찾기
        i = start + 1
        while i <= end and preorder[i] < root:
            i += 1
        
        # 후위 순회 순서: 왼쪽 - 오른쪽 - 루트
        # 스택은 LIFO이므로 역순으로 푸시
        
        # 루트 (나중에 출력하기 위해 is_print=True로 표시)
        stack.append((start, start, True))
        
        # 오른쪽 서브트리
        if i <= end:
            stack.append((i, end, False))
        
        # 왼쪽 서브트리
        if start + 1 <= i - 1:
            stack.append((start + 1, i - 1, False))

# 입력 처리
preorder = []
while True:
    try:
        line = sys.stdin.readline().strip()
        if not line:
            break
        preorder.append(int(line))
    except EOFError:
        break

# 후위 순회 결과 출력
post_order_without_recursion(preorder)