
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // 입출력
            int a = input.nextInt();
            int b = input.nextInt();
            int v = input.nextInt();

            System.out.println(solve(a, b, v));

    }

    public static long solve(int a, int b, int v) {
        long count = 0;
        if(v == a){
            return 1;
        }

        else {
             if ((v - a) % (a - b) == 0) {
                count = ((v - a) / (a - b));
             }
             else {
                 count = ((v - a) / (a - b))+1;
             }
        }
        return count+1;
    }
}
