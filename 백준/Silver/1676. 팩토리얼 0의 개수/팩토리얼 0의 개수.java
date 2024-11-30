

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();

        if (n1 == 0) {
            System.out.println(0);
            return;
        }

        int[] result = new int[10000]; // 결과 저장용 충분히 큰 배열
        result[0] = 1; // 초기값
        int resultSize = 1; // 결과 사이즈

        for (int i = 2; i <= n1; i++) {
            resultSize = multiply(i, result, resultSize);
        }

        int leadingZeroCount = 0;
        for (int i = 0; i < resultSize; i++) {
            if (result[i] == 0) {
                leadingZeroCount++;
            } else {
                break;
            }
        }

        System.out.println(leadingZeroCount);
    }

    // 주어진 x로 result 배열의 팩토리얼값을 갱신
    static int multiply(int x, int[] result, int resultSize) {
        int carry = 0; // 올림

        for (int i = 0; i < resultSize; i++) {
            int prod = result[i] * x + carry;
            result[i] = prod % 10; // 현재 자리수
            carry = prod / 10; // 올림 계산
        }

        while (carry != 0) {
            result[resultSize] = carry % 10;
            carry = carry / 10;
            resultSize++;
        }

        return resultSize;
    }
}