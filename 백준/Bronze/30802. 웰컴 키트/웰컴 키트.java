
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

        int [] size = new int[6];

        for(int i = 0; i < 6; i++){
            size[i] = sc.nextInt();
        }

        int t = sc.nextInt(); // 정수 티셔츠의 묶음 수
        int p = sc.nextInt(); // 펜의 묶음 수

        int count = 0;

        // 티셔츠
        for(int i = 0; i < 6; i++){
            if(0<size[i] &&size[i] <t){
                count++;
            }
            else if(size[i]%t == 0){
                count += size[i]/t;
            }
            else if(size[i]>t && size[i]%t !=0){
                count += size[i]/t+1;
            }
        }
        System.out.println(count);

        //펜을 P자루씩 최대 몇 묶음 주문할 수 있는지와,
        // 그 때 펜을 한 자루씩 몇 개 주문

        System.out.println(n/p +" "+ n%p);

    }
}




