
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        double so;
        int k;
        double result = 0.0;

        n = input.nextInt(); // 마디 수
        so = input.nextDouble();
        k = input.nextInt();
        double [] s = new double[k+1];
        s[0] = so;

        int [] m = new int[k+1];
        m[0] = 1;

        for(int i=0; i<k; i++){
            m[i+1] = input.nextInt();
            s[i+1] = input.nextDouble();
        }


        for(int i=0 ; i<k; i++){
            int f1 = m[i+1] - m[i];
            int f4 = f1*4;
            double f2 = s[i]/f4;

            double f3 = 60/f2;

            result += f3;

        }

        double f1 = n - m[m.length-1]+1;
        double f4 = f1 * 4;
        double f2 = s[s.length-1]/ f4;
        double f3 = 60/f2;
        result += f3;

        System.out.printf("%.12f\n", result);


    }
}
