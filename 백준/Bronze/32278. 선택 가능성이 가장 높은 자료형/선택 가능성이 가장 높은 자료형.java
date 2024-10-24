

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 배열 입력 받기
        long n = input.nextLong();

        if(-32768<= n && n<= 32767){
            System.out.println("short");
        }
        else if(-2147483648<= n && n<= 2147483647){
            System.out.println("int");
        }
        else if(-9223372036854775808L<= n && n<= 9223372036854775807L){
            System.out.println("long long");
        }

    }
}