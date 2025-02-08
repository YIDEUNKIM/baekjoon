import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int Q = Integer.parseInt(br.readLine());
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int MX = Arrays.stream(A).max().getAsInt();
        for (int l : L) {
            MX = Math.max(MX, l);
        }
        
        int[] D = new int[MX + 1];
        for (int a : A) {
            D[a]++;
        }
        
        for (int i = 2; i <= MX; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    D[i] += D[j];
                    if (j * j != i && j != 1) {
                        D[i] += D[i / j];
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int l : L) {
            sb.append(D[l]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}