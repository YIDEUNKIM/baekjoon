
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean flag = false;

        outer:
        for(int i = 1; i < 10; i++) {
            for(int j=1; j < 10; j++) {
                if(i*j == n) {
                    System.out.println(1);
                    flag = true;
                    break outer;
                }
            }
        }

        if(!flag) {
            System.out.println(0);
        }



    }
}




