
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // 입출력
            int n1 = input.nextInt();
            int n2 = input.nextInt();


            System.out.println(test(n1, n2));

    }

    public static int test(int n1, int n2) {
        int n1_result = 1;
        int n2_result = 1;
        int n1_n2_result = 1;
        for(int i=n1; i>0; i--){
            n1_result *= i;
        }
        for(int i=n2; i>0; i--){
            n2_result *= i;
        }
        for(int i=n1-n2; i>0; i--){
            n1_n2_result *= i;
        }

        int result = n1_result/(n2_result*n1_n2_result);

        return result;
    }
}
