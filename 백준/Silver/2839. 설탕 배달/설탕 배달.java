
import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/32372">...</a>
 *
 * 문제에서 정의한 보물에 위치 조건을 여사건을 통해
 * 먼저 보물이 없는 곳을 특정해 낸다.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean found = false;
            outer:
            for (int i = 0; i < 1700; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (3 * i + 5 * j == n) {
                        System.out.println(i + j);
                        found = true;
                        break outer;
                    }
                }
            }

            if(!found){
                System.out.println(-1);
            }


    }
}




