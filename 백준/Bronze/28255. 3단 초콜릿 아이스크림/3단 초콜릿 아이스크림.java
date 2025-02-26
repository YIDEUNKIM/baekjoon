

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt(); // 테스트 케이스 개수
        //Math.ceil

        for (int i = 0; i < T; i++) {
            String s = input.next();

            String s1 = s.substring(0, (int) Math.ceil((double) s.length() /3));
            String rev = new StringBuilder(s1).reverse().toString();
            String tail = s1.substring(1);


            if(s.equals(s1+rev+s1)) {
                System.out.println("1");
            }
            else if(s.equals(s1 + rev.substring(1) + s1)) {
                System.out.println("1");
            }
            else if(s.equals(s1+rev + tail)) {
                System.out.println("1");
            }
            else if(s.equals(s1+ rev.substring(1) + tail)) {
                System.out.println("1");
            }

            else
                System.out.println("0");
        }

        input.close();
    }
}
