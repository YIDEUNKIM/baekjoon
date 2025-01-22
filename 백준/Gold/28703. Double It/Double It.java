import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Long> pq = new PriorityQueue<>();
        int t = input.nextInt();

        long max = Long.MIN_VALUE; // long 타입 중 가장 작은 값
        for (int i = 0; i < t; i++) {
            long num = input.nextLong();
            pq.add(num);
            max = Math.max(max, num); // 최대값 갱신
        }

        long curmax = max;
        long result = curmax - pq.peek();

        while (pq.peek() < max) {
            long min = pq.poll();
            result = Math.min(result, curmax - min);
            curmax = Math.max(curmax, 2 * min);
            pq.add(2L * min);
        }

        System.out.println(Math.min(curmax- pq.peek(), result));
    }
}
