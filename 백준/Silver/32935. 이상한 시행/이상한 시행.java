import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 입력 처리
        int n = input.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextLong();
        }

        long sum = Arrays.stream(a).sum(); // 초기 합 계산
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 최소값 우선 선택

        for (long value : a) {
            pq.add(value);
        }

        // 시행 반복
        while (true) {
            long min = pq.poll(); // 최소값 선택
            if (-sum <= min) {
                // 종료 조건: -S가 최소값보다 크거나 같을 때
                System.out.println(sum);
                break;
            }

            // 최소값을 -S로 바꾸고 다시 합 계산
            pq.add(-sum);
            sum = sum - min - sum; // 새로운 합 계산
        }
    }
}
