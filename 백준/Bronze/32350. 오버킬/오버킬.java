
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int d = input.nextInt();
        int k = input.nextInt();
        int [] a = new int[n];

        for(int i=0; i<n; i++)
            a[i] = input.nextInt();


        int turn = 0;

        for(int i=0; i<n; i++){
            if(a[i] <= 0) { // 이미 죽어있음
                continue;
            }

            if(a[i] < d) { // 첫 공격이 오버킬
                turn++;
                int h = d - a[i];
                if( i == n-1)
                    break;

                a[i+1] -= h*k/100;
                continue;
            }
            
            turn += a[i] / d;
            int remain_health = a[i] %d;

            if(remain_health != 0){ // 오버킬 발생
                turn++;

                int h = d - remain_health;

                if(i == n-1){
                    break;
                }

                a[i+1] -= h*k /100;
            }
            

        }
        System.out.println(turn);
    }
}
