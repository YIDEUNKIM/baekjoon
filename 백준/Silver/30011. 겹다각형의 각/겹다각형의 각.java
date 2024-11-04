import java.util.*;


class Main {

    public static void main(String[] args) {
       Scanner input  = new Scanner(System.in);

       int n = input.nextInt();
       int [] a = new int [n];

       for(int i=0; i<n; i++){
            a[i] = input.nextInt();
       }
       int sum = 180*(a[0]-2);

       if(n==1)
           System.out.println(180*(a[0]-2));
       else{
           for(int i=1; i<n; i++){
               sum += a[i]*180;
           }
           System.out.println(sum);
        }
    }
}