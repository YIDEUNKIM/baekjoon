

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int n = input.nextInt();

            if (n == 1) {
                System.out.println(0);
            } else if (n == 2) {
                System.out.println(11);
            } else if (n == 3) {
                System.out.println(121);
            } else {
                // BigInteger를 사용하여 10^(n-2) + 1 계산
                BigInteger base = BigInteger.TEN.pow(n - 2).add(BigInteger.ONE);
                BigInteger result = BigInteger.valueOf(11).multiply(base);
                System.out.println(result);
            }
        }
        input.close();
    }
}
