import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        int resultCount = 0;
        int [] a = new int [n+1];
        int [] b = new int [n+1];

        for(int i=1; i<=n; i++){
            a[i] = input.nextInt();
        }

        int indexCount;

        while(true){

            count = 0;
            resultCount++;
            
            for(int i=1; i<=n; i++){
                indexCount = 0;
                for(int j=i; j<n; j++){
                    if(a[i] < a[j+1]){
                        indexCount++;
                    }
                }

                b[i] = indexCount;
                indexCount = 0;
                if(a[i] == b[i]){
                    count++;
                }
            }

            // 각 B_i$는A_{i+1},A_{i+2},\ldots ,A_N 중
            // A_i$보다 큰 원소의 개수로 정의된다.

            if(count == n){
                System.out.println(resultCount);
                break;
            }
            System.arraycopy(b,1,a,1,n);
        }
    }

}