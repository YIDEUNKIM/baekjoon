import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 입출력
        int t = input.nextInt();
        int x=0;
        while(x<t){
            int k = input.nextInt();
            int n = input.nextInt();
            int result = test(k, n);

            System.out.println(result);
            x++;
        }
        input.close();



    }

    public static int test(int k, int n) {
        int [][] list = new int [15][15];
        for(int i=0; i<15; i++){
            list[0][i] = i;
        }



        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                //////////////
                list[i][j] = list[i-1][j] + list[i][j-1];
            }
        }
        int sum = list[k][n];

        return sum;
    }
}
