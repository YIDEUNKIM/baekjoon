
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt(); // 포지션 제로 중심 (x,y) 포지션 제로는 원으로 표현
        int y = input.nextInt(); //
        int r = input.nextInt(); // 반지름

        int [] count_line = new int[1];
        int [] count_in = new int[1];


        int [] t_i = new int[n];
        for(int i=0; i<n; i++) {
            int num = input.nextInt(); // 각 직선 t_i
            t_i[i] = num;
            // 바나나는 n개의 직선 중 하나를 골라 그 위에서만 존재
        }
        // 포지션 내부로 들어갈 수 있는 직선의 개수 a와
        // 경계에만 들어갈 수 있는 b

        for(int i=0; i<n; i++) {
            if (r*r == (x - t_i[i])*(x - t_i[i])) {
                count_line[0]++;
            }
            else if (r*r > (x - t_i[i])*(x - t_i[i])) {
                count_in[0]++;
            }
        }

        System.out.println(count_in[0] +" "+ count_line[0]);

    }
}