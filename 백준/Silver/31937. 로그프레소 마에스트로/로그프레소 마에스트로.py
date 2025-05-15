def solve():
    N, M, K = map(int, input().split())
    infected = list(map(int, input().split()))

    logs = []
    for _ in range(M):
        t, a, b = map(int, input().split())
        logs.append((t, a, b))

    logs.sort()

    # 각 감염된 컴퓨터를 최초 감염 컴퓨터로 가정하고 시뮬레이션
    for initial in infected:
        # 현재 감염된 컴퓨터들을 집합으로 관리
        current_infected = {initial}

        # 시간 순서대로 전송 로그 처리
        for t, a, b in logs:
            # a가 감염된 상태이면 b도 감염됨
            if a in current_infected:
                current_infected.add(b)

        # 시뮬레이션 결과가 실제 감염된 컴퓨터들과 일치하는지 확인
        if current_infected == set(infected):
            print(initial)
            return


solve()