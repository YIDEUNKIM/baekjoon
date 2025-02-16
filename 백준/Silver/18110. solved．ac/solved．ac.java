

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double num = n * 0.15;
        long result = Math.round(num);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(k);
        }
        br.close(); // BufferedReader 닫기

        Collections.sort(list);

        int sum = list.subList((int) result, list.size() - (int) result)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(Math.round((double) sum / (list.size() - result * 2)));
    }
}
