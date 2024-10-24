import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();
        int r = input.nextInt();
        int s = input.nextInt();
        int a_1 = input.nextInt();

        int sum = 0;
        int [] list = new int [n*20];
        list[1] = a_1;

        for(int i=1; i<n; i++) {
            list[2*i] = p*list[i]+q;
            list[2*i+1] = r*list[i]+s;
        }

        for(int i=1; i<=n; i++){
            sum += list[i];
        }
         // n이 짝수 일때

        System.out.println(sum);
    }
}