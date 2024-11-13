
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static long dolmen(int a, int b) {
        long sum = 0;
        int result = (int) Math.pow((a+b), 2);
        sum = sum + (long)result * (a + b - 1) / 2;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(dolmen(a,b));
        }
        for(long x : arr) {
            System.out.println(x);
        }

    }

}