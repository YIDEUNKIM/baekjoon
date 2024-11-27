
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        // 리스트를 뒤집은 복사본 생성
        int[] reversedList = new int[n];
        for (int i = 0; i < n; i++) {
            reversedList[i] = list[n - i - 1];
        }

        long maxSum1 = calculateMaxSum(list, n, k);
        long maxSum2 = calculateMaxSum(reversedList, n, k);

        System.out.println(Math.max(maxSum1, maxSum2));
    }

    // 최대합 계산 메서드
    private static long calculateMaxSum(int[] list, int n, int k) {
        long maxSum = Long.MIN_VALUE;

        // 누적합 배열 생성
        long[] prefixSum = new long[n];
        prefixSum[0] = list[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + list[i];
        }

        // 최대값 계산
        for (int i = 0; i < Math.min(n, k); i++) {
            long sum = prefixSum[i]; // i까지의 누적합
            sum += (long) list[i] * (k - i - 1); // 마지막 항에 가중치 추가
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
