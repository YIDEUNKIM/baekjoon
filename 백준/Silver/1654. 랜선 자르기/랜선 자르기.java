

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int k = sc.nextInt();  // 랜선 개수
        int n = sc.nextInt();  // 필요한 랜선 개수

        long[] lengths = new long[k];
        long maxLen = 0;

        // 랜선 길이 입력 받기
        for (int i = 0; i < k; i++) {
            lengths[i] = sc.nextLong();
            maxLen = Math.max(maxLen, lengths[i]);  // 최대 랜선 길이 갱신
        }

        // 이진 탐색 시작
        long left = 1;
        long right = maxLen;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // mid 길이로 자를 수 있는 랜선의 개수 계산
            for (long len : lengths) {
                count += len / mid;
            }

            if (count >= n) {  // 원하는 개수 이상 만들 수 있으면 더 큰 길이 탐색
                answer = mid;
                left = mid + 1;
            } else {  // 개수가 부족하면 길이를 줄여야 함
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
