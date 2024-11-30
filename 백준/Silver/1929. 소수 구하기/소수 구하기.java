

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        List<Integer> primes = IntStream.range(n1, n2+1)
                .filter(Main::isPrime)
                .boxed()
                .collect(Collectors.toList());

        for(int factor : primes){
            System.out.println(factor);
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .allMatch(n -> number % n != 0);
    }
}
