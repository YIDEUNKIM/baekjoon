

import java.util.*;

/**
 * 출력이 안됨
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int Acount = 0;
        int Ncount = 0 ;
        int result = 0;

        for(int k = 0; k<n; k++) {
            String s = input.next();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'W') {
                    Acount++;
                } else if (Acount == 1 && s.charAt(i) == 'O') {
                    Ncount++;
                }

                if (Acount == 2 && Ncount == 1) {
                    result++;
                    Acount = 1;
                    Ncount = 0;
                }
                if (Acount == 2) {
                    Acount = 1;
                    Ncount = 0;
                }
            }
            System.out.println(result);
            result = 0;
            Acount = 0;
            Ncount = 0;
        }
    }
}