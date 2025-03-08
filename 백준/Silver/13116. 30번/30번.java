
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 0; i < t; i++) {
            Set<Integer> aset = new HashSet<>();
            Set<Integer> bset = new HashSet<>();
            int a = input.nextInt();
            int b = input.nextInt();

            // a의 부모 노드들을 저장
            while (a > 0) {
                aset.add(a);
                a /= 2;  // 부모 노드로 이동
            }

            // b의 부모 노드들을 저장
            while (b > 0) {
                bset.add(b);
                b /= 2;  // 부모 노드로 이동
            }

            // 공통 조상 찾기
            aset.retainAll(bset);
            System.out.println(10*Collections.max(aset));
        }
    }
}
