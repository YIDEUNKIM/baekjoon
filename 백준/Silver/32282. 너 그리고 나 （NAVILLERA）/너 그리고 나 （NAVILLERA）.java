
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int c = input.nextInt();
        double sum = 0.0;
        int count = 0;
        double xy = Math.sqrt(x*x + y*y);

        if(x==0 && y == 0){
            System.out.println(0);
        }

        else if(Math.sqrt(x*x + y*y) < c){
            System.out.println(2);
        }

        else if(Math.sqrt(x*x + y*y) == c){
            System.out.println(1);
        }

        else {
            while (true) {
                sum += c;
                count++;
                if (sum >= xy) {
                    System.out.println(count);
                    break;
                }
            }
        }


    }
}