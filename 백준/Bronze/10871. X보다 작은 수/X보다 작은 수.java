

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int [] list = new int [a];
        
        for(int i = 0; i < a; i++){
            list[i] = sc.nextInt();
        }
        for(int i = 0; i < a; i++) {
            if(list[i] < b) {
                System.out.print(list[i]+" ");
            }
        }

    }
}
