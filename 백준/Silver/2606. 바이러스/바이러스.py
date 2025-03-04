from collections import deque

# BFS 함수 정의
def bfs(graph, start, visited):
    queue = deque([start])  # 시작 노드(1번 컴퓨터)를 큐에 추가
    visited[start] = True  # 시작 노드 방문 처리
    infected = 0  # 감염된 컴퓨터 수 (1번 제외)
    
    while queue:
        current = queue.popleft()  # 현재 노드 꺼내기
        
        # 현재 노드와 연결된 모든 노드 탐색
        for neighbor in graph[current]:
            if not visited[neighbor]:  # 방문하지 않았다면
                queue.append(neighbor)  # 큐에 추가
                visited[neighbor] = True  # 방문 처리
                infected += 1  # 감염된 컴퓨터 수 증가
                
    return infected
    
    
# 입력 처리
N = int(input())  # 컴퓨터 수
M = int(input())  # 네트워크 연결 쌍 수

# 그래프를 인접 리스트로 표현
graph = [[] for _ in range(N + 1)]  # 1번부터 N번까지 사용하므로 N+1 크기
visited = [False] * (N + 1)  # 방문 여부 체크 배열

# 네트워크 연결 정보 입력
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)  # 양방향 연결
    graph[b].append(a)  # 무방향 그래프이므로 반대 방향도 추가

# BFS 실행 및 결과 출력
result = bfs(graph, 1, visited)  # 1번 컴퓨터에서 시작
print(result)  # 감염된 컴퓨터 수 출력