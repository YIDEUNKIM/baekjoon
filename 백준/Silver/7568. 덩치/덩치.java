

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] list = new int[n][2];

        for(int i = 0; i < n; i++){
            list[i][0] = sc.nextInt();
            list[i][1] = sc.nextInt();
        }

        int[] answer = new int[n];

        int count;
        for(int i = 0; i < n; i++){
            count = 1;
            for(int j=0; j<n; j++ ) {
                if(i != j){
                    if(list[i][0] < list[j][0] && list[i][1] < list[j][1]){
                        count++;
                    }
                }

            }
            answer[i] = count;
        }
        for(int i = 0; i < n-1; i++){
            System.out.print(answer[i]+" ");
        }
        System.out.print(answer[n-1]);

    }
}