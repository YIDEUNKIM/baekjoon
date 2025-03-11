

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        List<Character> printer = new ArrayList<>();

        int n = input.nextInt();
        int[] sequence = new int[n]; // 입력 수열
        for (int i = 0; i < n; i++) {
            sequence[i] = input.nextInt();
        }

        int num = 1; // 스택에 넣을 다음 숫자
        int idx = 0; // 수열의 현재 위치

        while (idx < n) {
            if (!stack.isEmpty() && stack.peek() == sequence[idx]) {
                // 스택 맨 위가 현재 수열 값과 같으면 pop
                stack.pop();
                printer.add('-');
                idx++;
            } else if (num <= n) {
                // 다음 숫자를 push
                stack.push(num);
                printer.add('+');
                num++;
            } else {
                // 더 이상 push할 숫자가 없고 pop도 불가능하면 실패
                System.out.println("NO");
                return;
            }
        }

        // 수열을 모두 만들었다면 연산 출력
        for (char op : printer) {
            System.out.println(op);
        }
    }
}