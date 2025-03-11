

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long [] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for(int i=0; i<n; i++) {
            int k = input.nextInt();

            System.out.println(dp[k]);
        }
    }
}