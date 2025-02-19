import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 이진수의 자리수
        int a = scanner.nextInt();  // x에서 1의 개수
        int b = scanner.nextInt();  // y에서 1의 개수
        scanner.close();
        
        // x와 y에서 서로 다른 자리에서 1이 나타날 수 있는 최대 개수
        int u;
        if (a + b <= N) {
            u = a + b;
        } else {
            u = 2 * N - (a + b);
        }
        
        // u개의 1을 최상위 자리부터 배치하여 N자리 이진수 중 최대값 계산
        int maxXor = ((1 << u) - 1) << (N - u);
        
        System.out.println(maxXor);
    }
}