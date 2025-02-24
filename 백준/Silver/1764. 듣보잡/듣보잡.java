

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        List<String> list1 = new ArrayList<>();

        int n = input.nextInt();
        int m = input.nextInt();

        for(int i = 0; i < n; i++) {
            String s = input.next();
            set1.add(s);
        }

        for(int i=0;i<m;i++) {
            String s = input.next();
            set2.add(s);
        }

        set2.retainAll(set1);
        System.out.println(set2.size());
        for(String s : set2) {
            System.out.println(s);
        }



    }
}