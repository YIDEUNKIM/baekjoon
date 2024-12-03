
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cho = 72;
        double han = 73.5;
        double [] cho_sc = new double[6];
        double [] han_sc = new double[6];

        for(int i=0; i<6; i++){
            cho_sc[i] = sc.nextDouble();
        }
        for(int i=0; i<6; i++){
            han_sc[i] = sc.nextDouble();
        }

        double result_c = cho- 13*(2-cho_sc[0]) - 7*(2-cho_sc[1]) - 5*(2-cho_sc[2]) - 3*(2-cho_sc[3]) - 3*(2-cho_sc[4]) - 2*(5-cho_sc[5]);
        double result_h = han - 13*(2-han_sc[0]) - 7*(2-han_sc[1]) - 5*(2-han_sc[2]) - 3*(2-han_sc[3]) - 3*(2-han_sc[4]) - 2*(5-han_sc[5]);

        if(result_c > result_h){
            System.out.println("cocjr0208");
        }
        else if(result_c < result_h)
            System.out.println("ekwoo");

    }
}
