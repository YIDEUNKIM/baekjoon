

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 출력이 안됨
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        String tie = "Tie";

        for(int i=0; i<20; i++) {
            int n = input.nextInt();
            list.add(n);
        }

        double bobValue = (double)list.stream().mapToInt(Integer::intValue).sum() / 20;
        int maxIndex = list.indexOf(Collections.max(list));
        double aliceValue;
        if(maxIndex == 0) {
            aliceValue = (double) (Collections.max(list) + list.get(1) + list.get(19)) / 3;
            if(bobValue > aliceValue) {
                System.out.println("Bob");
            }
            else if (bobValue < aliceValue) {
                System.out.println("Alice");
            }
            else
                System.out.println("Tie");
        }
        else if (maxIndex == 19) {
            aliceValue = (double) (Collections.max(list) + list.get(0) + list.get(18)) / 3;
            if(bobValue > aliceValue) {
                System.out.println("Bob");
            }
            else if (bobValue < aliceValue) {
                System.out.println("Alice");
            }
            else
                System.out.println("Tie");
        }
        else {
            aliceValue = (double) (Collections.max(list) + list.get(maxIndex-1) + list.get(maxIndex+1)) / 3;
            if(bobValue > aliceValue) {
                System.out.println("Bob");
            }
            else if (bobValue < aliceValue) {
                System.out.println("Alice");
            }
            else
                System.out.println("Tie");
        }
    }
}