

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine().trim());
        int[] list = new int[n1];

        for (int i = 0; i < n1; i++) {
            list[i] = Integer.parseInt(reader.readLine().trim());
        }

        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int factor : list) {
            sb.append(factor).append("\n");
        }
        System.out.print(sb.toString());
    }
}
