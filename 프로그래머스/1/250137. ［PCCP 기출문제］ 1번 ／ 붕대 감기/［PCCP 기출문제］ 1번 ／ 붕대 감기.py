def solution(bandage, health, attacks):
    max_health = health  # 최대 체력 저장
    current_health = health  # 현재 체력
    continuous_success = 0  # 연속 성공 횟수

    attacks_dict = dict(attacks)  # 공격 정보를 딕셔너리로 변환

    for time in range(1, attacks[-1][0] + 1):
        if time in attacks_dict:  # 공격 발생
            current_health -= attacks_dict[time]
            if current_health <= 0:
                return -1
            continuous_success = 0
            last_attack_time = time
        else:  # 회복
            current_health = min(max_health, current_health + bandage[1])
            continuous_success += 1
            if continuous_success == bandage[0]:
                current_health = min(max_health, current_health + bandage[2])
                continuous_success = 0

    return current_health