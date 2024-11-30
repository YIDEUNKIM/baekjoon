import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자 입력 받기
        String first = sc.nextLine();
        String second = sc.nextLine();
        String third = sc.nextLine();
        
        int next = 0;
        
        // 문자열이 숫자인지 판단하고 next 값을 설정
        if (isNumeric(first)) {
            next = Integer.parseInt(first) + 3;
        } else if (isNumeric(second)) {
            next = Integer.parseInt(second) + 2;
        } else if (isNumeric(third)) {
            next = Integer.parseInt(third) + 1;
        }

        // FizzBuzz 조건에 따른 출력
        if (next % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (next % 3 == 0) {
            System.out.println("Fizz");
        } else if (next % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(next);
        }
    }

    // 문자열이 숫자인지 확인하는 메서드
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}