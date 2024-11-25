
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 분해합 입력
        int n = input.nextInt();
        int result = Main.test(n);

        System.out.println(result);


    }

    public static int test(int n) {

        int min = (n - (9 * ((int) Math.log10(n) + 1)));
        if (min < 1) {
            min = 1;
        }


        for (int i = min; i < n; i++) {
            int decomposition_sum = i;
            int temp = i;

            while (temp > 0) {
                decomposition_sum += temp % 10;
                temp /= 10;
            }

            if (decomposition_sum == n) {
                return i;

            }
        }
        return 0;
    }
}
