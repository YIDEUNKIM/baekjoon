
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        int [] list = new int [k];
        for(int i=0; i<k; i++) {
            int a = input.nextInt();

            double p = (double)(a*100)/n;

            if(0<=(int)p && (int)p<=4)
                list[i] = 1;
            else if(4<(int)p && (int)p<=11)
                list[i] = 2;
            else if(11<(int)p && (int)p<=23)
                list[i] = 3;
            else if(23<(int)p & (int)p<=40)
                list[i] = 4;
            else if(40<(int)p && (int)p<=60)
                list[i] = 5;
            else if(60<(int)p && (int)p<= 77)
                list[i] = 6;
            else if(77<(int)p && (int)p<=89)
                list[i] = 7;
            else if(89<(int)p && (int)p<=96)
                list[i] = 8;
            else if(96<(int)p && (int)p<=100)
                list[i] = 9;
        }

        for(int i=0; i<k-1; i++){
            System.out.print(list[i]+" ");
        }
        System.out.print(list[k-1]);



    }
}