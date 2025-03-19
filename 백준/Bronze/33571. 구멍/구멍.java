

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split("");

        int count = 0;
        for (String i : str){
            if (i.equals("A") ||i.equals("a") || i.equals("b") ||i.equals("D") ||i.equals("d") ||i.equals("O") ||i.equals("o") ||i.equals("p") ||i.equals("P") ||i.equals("Q") ||i.equals("q") ||i.equals("R") || i.equals("e") || i.equals("g")) {
                count++;
            }
            else if (i.equals("B")) {
                count +=2;
            }
            else if (i.equals("@")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
