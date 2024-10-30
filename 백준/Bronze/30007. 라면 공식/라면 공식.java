import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for(int i=0; i<n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int x = input.nextInt();

            System.out.println(a*(x-1)+b);
        }




    }
}