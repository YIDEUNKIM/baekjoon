

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static int [] arr;
    public static boolean[] visit;
    public static Set<Integer> set;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        arr = new int[m];
        visit = new boolean[n];
        set = new TreeSet<>();
        dfs(n, m, 0);
    }

    public static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(n, m, depth+1);
                visit[i] = false;
            }
        }
    }
}