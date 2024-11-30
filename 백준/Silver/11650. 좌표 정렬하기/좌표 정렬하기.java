

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [][] list = new int[n1][2];

        for(int i=0; i<n1; i++) {
            for(int j=0; j<2; j++) {
                list[i][j] = sc.nextInt();
            }
        }

        Comparator<int[]> comp = (a, b) -> {
            // x좌표가 증가하는 순서로
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                // x좌표가 같으면 y좌표가 증가하는 순서로
                return Integer.compare(a[1], b[1]);
            }
        };

        Arrays.sort(list, comp);

        // 정렬된 좌표 출력
        for (int[] point : list) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}