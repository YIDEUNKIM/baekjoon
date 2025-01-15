

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int [] trash = new int[7];
        int t = input.nextInt();


        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> people = new ArrayList<>();

        for (int i = 0; i < 2*n; i++) {
            list.add(input.nextInt());
        }

        for(int i=0; i<t; i++) {
            list1.add(input.nextInt());
        }

        for(int j=0; j<t; j++) {
            for (int i = 0; i < list1.get(j)-1; i++) {
                list.add(list.get(0));
                list.remove(0);
            }
            people.add(list.get(0));
        }

        for(int i=0; i< people.size()-1; i++) {
            System.out.print(people.get(i)+" ");
        }
        System.out.print(people.get(people.size()-1));
    }
}