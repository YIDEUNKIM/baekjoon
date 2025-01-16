

import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Q = input.nextInt(); // 쿼리 수
        int[] N = new int[Q];

        for (int i = 0; i < Q; i++) {
            N[i] = input.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            System.out.println(computeGenuineEvenNumberCount(N[i]));
        }
    }

    // 찐 Even Number의 개수를 계산
    private static long computeGenuineEvenNumberCount(int n) {
        if (n == 1) return 5; // 1자리 수는 {0, 2, 4, 6, 8}
        
        // Count(N) = 4 * 5^(N-1) % MOD
        long result = 4 * modularExponentiation(5, n - 1, MOD) % MOD;
        return result;
    }

    // 모듈러 거듭제곱 (base^exp % mod 계산)
    private static long modularExponentiation(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) { // 홀수인 경우
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1; // 지수 나누기 2
        }

        return result;
    }
}
