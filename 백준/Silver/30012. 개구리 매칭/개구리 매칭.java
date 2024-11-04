import java.util.*;

/**
 * 개구리 사이의 거리를 x라고 하면,
 * case 1) x가 2*k보다 크거나 같을 때,
 *
 */
 public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s = input.nextInt(); // 주호의 위치
        int n = input.nextInt(); // n마리의 개구리

        int [] e_i = new int[n];
        for(int i=0; i<n; i++){
            e_i[i] = input.nextInt(); // 개구리의 위치
        }
        int k = input.nextInt();
        int l = input.nextInt();

        int energy;
        int energyValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0 ; i<n; i++){
            int x = Math.abs((e_i[i]-s));
            if( x >= 2*k){
                energy = (x-2*k)*l;
            }
            else{
                energy = (2*k-x);
            }
            if(energy<=energyValue){
                energyValue = energy;
                minIndex = i+1;
            }
        }
        System.out.println(energyValue+" "+ minIndex); // 서로의 체력 소모의 합의 최소와 그 개구리의 번호를 공백으로 구분하여 출력


    }
}