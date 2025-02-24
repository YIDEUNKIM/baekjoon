

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int n = input.nextInt();

        for(int i = 0; i < n; i++) {
            int s = input.nextInt();
            list1.add(s);
        }

        Collections.sort(list1);

        int sum = 0;
        for(int i=0;i<list1.size();i++) {
            sum = 0;
            for(int j=0; j<i+1;j++) {
                sum += list1.get(j);
            }
           
            list2.add(sum);
        }

        System.out.println(list2.stream().mapToInt(x -> x).sum());





    }
}