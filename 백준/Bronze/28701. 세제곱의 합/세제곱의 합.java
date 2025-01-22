
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();

        int n = input.nextInt();

        long one = n*(n+1)/2;
        long two = (n*(n+1)/2) * (n*(n+1)/2);
        long three =  (n*(n+1)/2) * (n*(n+1)/2);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

    }
}
