

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 초기값 추가
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 큐에서 첫 번째 값을 제거하고 다음 값을 다시 큐의 끝에 추가
        while (queue.size() > 1) {
            queue.poll(); // 첫 번째 값 제거
            queue.add(queue.poll()); // 두 번째 값을 큐의 끝에 추가
        }

        // 마지막 남은 값 출력
        System.out.println(queue.poll());
    }
}
