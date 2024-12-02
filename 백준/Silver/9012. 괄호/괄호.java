

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] list = new String[n];

        for(int i=0; i<n; i++){
            list[i] = sc.next();
        }

        String[] result = new String[n];

        int count = 0;
        for(int i=0; i<n; i++){
            count = 0;
            for(int j=0; j<list[i].length(); j++){
                if(list[i].charAt(j) == '(')
                    count++;

                else if(list[i].charAt(j) == ')')
                    count--;

                if(count<0) {
                    result[i] = "NO";
                    break;
                }
            }
            if(count >=0){
                if (count == 0)
                    result[i] = "YES";

                else
                    result[i] = "NO";
            }
        }

        for(int i=0; i<n; i++)
            System.out.println(result[i]);

    }
}