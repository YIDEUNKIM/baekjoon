

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int five = 0;

        for(int i=1; i<=n1; i++){
            int j=i;

            while(j%5==0){
                five++;
                j=j/5;
            }
        }
        System.out.println(five);

    }


}