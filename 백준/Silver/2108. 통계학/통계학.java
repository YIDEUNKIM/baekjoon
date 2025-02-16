

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 첫 번째 입력: 숫자의 개수 (n은 홀수)

        List<Integer> list = new ArrayList<>();

        // 숫자 n개 입력 받기 (한 줄씩)
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 산술평균 (반올림)
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(Math.round((double) sum / n));

        // 중앙값
        Collections.sort(list);
        System.out.println(list.get(n / 2));

        // 최빈값 구하기
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : list) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Collections.max(freqMap.values());
        List<Integer> modeCandidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modeCandidates.add(entry.getKey());
            }
        }

        Collections.sort(modeCandidates);
        int mode = (modeCandidates.size() > 1) ? modeCandidates.get(1) : modeCandidates.get(0); // 최빈값이 여러 개일 경우 두 번째 값 선택
        System.out.println(mode);

        // 범위 (최댓값 - 최솟값)
        int range = Collections.max(list) - Collections.min(list);
        System.out.println(range);
    }
}
