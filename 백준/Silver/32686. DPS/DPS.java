
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int e = scanner.nextInt();

        double res = 0.0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int x = f(e, a, b) - f(s, a, b); //
            res += x * ((double) c / b);
        }

        System.out.printf("%.20f%n", res / (e - s));
    }

    private static int f(int n, int a, int b) {
        int res = n / (a + b) * b;
        n %= (a + b);
        if (n > a) res += n - a;
        return res;
    }
}