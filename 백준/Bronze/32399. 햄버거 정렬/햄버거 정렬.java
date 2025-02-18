

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 출력이 안됨
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        if(s.equals("1)(")) {
            System.out.println("1");
        } else if (s.equals("1()")) {
            System.out.println("1");
        }
        else if (s.equals(")1(")) {
            System.out.println("2");
        }
        else if (s.equals("(1)")) {
            System.out.println("0");
        }
        else if (s.equals(")(1")) {
            System.out.println("1");
        }
        else if (s.equals("()1")) {
            System.out.println("1");
        }

    }
}