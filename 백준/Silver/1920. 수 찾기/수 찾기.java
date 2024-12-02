
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] list1 = new int [n];

        for(int i = 0; i < n; i++)
            list1[i] = sc.nextInt();

        int m = sc.nextInt();
        int [] list2 = new int [m];

        for(int i = 0; i < m; i++)
            list2[i] = sc.nextInt();

        int [] cheak = new int [m];
        Arrays.sort(list1);

        for(int i=0; i<m; i++){
            if(Arrays.binarySearch(list1, list2[i])>=0){
                cheak[i] = 1;
            }
        }

        for(int i=0; i<m; i++){
            System.out.println(cheak[i]);
        }

    }
}