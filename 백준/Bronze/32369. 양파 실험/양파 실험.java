

import java.util.Scanner;

/**
 * B번 문제
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int chingOnion = 1;
        int biOnion = 1;
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=0; i<n; i++){
            chingOnion = chingOnion + a;
            biOnion = biOnion + b;

            if(chingOnion < biOnion){
                int tmp = chingOnion;
                chingOnion = biOnion;
                biOnion = tmp;
            }
            else if (chingOnion == biOnion) {
                biOnion --;
            }
        }

        System.out.println(chingOnion + " " + biOnion);



    }
}

