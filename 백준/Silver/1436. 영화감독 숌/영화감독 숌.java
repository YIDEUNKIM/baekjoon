import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // N번째 종말의 수를 찾기 위한 입력

        int count = 0; // 종말의 수를 찾은 개수
        int number = 666; // 첫 번째 종말의 수부터 시작


        while (count < n) {
            String str = Integer.toString(number); // 숫자를 문자열로 변환
            if (str.contains("666")) { // 연속된 "666"을 포함하는지 확인
                count++; // 종말의 수 카운트 증가
            }
            if (count < n) { // 아직 N번째 종말의 수가 아닌 경우
                number++; // 다음 숫자로 이동
            }
        }

        System.out.println(number); // N번째 종말의 수 출력
    }
}
