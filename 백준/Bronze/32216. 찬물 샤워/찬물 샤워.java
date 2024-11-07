
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bul = 0; // 불쾌감 지수

        int n = input.nextInt();
        int k = input.nextInt();
        int t0 = input.nextInt();
        int [] ti = new int[n+1];
        ti[0] = t0;
        int [] list = new int [n+1];

        for(int i=1; i<=n; i++){
            list[i] = input.nextInt();
        }

        for(int i=0; i<n; i++){
            if(ti[i]>k){
                ti[i+1] = ti[i] + list[i+1] - Math.abs(ti[i]-k);
            }
            else if(ti[i]<k){
                ti[i+1] = ti[i] + list[i+1] + Math.abs(ti[i]-k);
            }
            else{
                ti[i+1] = ti[i] + list[i+1];
            }
        }

        for(int i=1; i<=n; i++){
            bul +=Math.abs(ti[i]-k);
        }
        System.out.println(bul);
    }

}