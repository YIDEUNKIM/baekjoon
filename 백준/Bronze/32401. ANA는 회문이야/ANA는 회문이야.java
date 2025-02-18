

import java.util.*;

/**
 * 출력이 안됨
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String s = input.next();

        int Acount = 0;
        int Ncount = 0 ;
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'A') {
                Acount++;
            }
            else if (Acount == 1 && s.charAt(i)=='N') {
                Ncount++;
            }

            if(Acount == 2 && Ncount == 1) {
                result++;
                Acount = 1;
                Ncount = 0;
            }
            if(Acount == 2) {
                Acount = 1;
                Ncount = 0;
            }
        }

        System.out.println(result);
    }
}