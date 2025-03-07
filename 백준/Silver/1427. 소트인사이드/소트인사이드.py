w = input()  # 문자열 입력
w_list = list(w)  # 문자열을 리스트로 변환

for j in range(0, len(w_list)):
    for i in range(0, len(w_list)-1):
        if w_list[i] < w_list[i+1]:  # 사전순으로 앞서는 경우
            tmp = w_list[i]
            w_list[i] = w_list[i+1]
            w_list[i+1] = tmp

w = ''.join(w_list)  # 리스트를 다시 문자열로 변환
print(w)