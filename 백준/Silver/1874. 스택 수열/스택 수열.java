

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        List<Character> printer = new ArrayList<>();
        int n = input.nextInt();
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(input.nextInt());
        }

        int i = 1;
        int j = 0;

        while(j < n) {
            if(!stack.isEmpty() && stack.peek().equals(list.get(j))) {
                stack.pop();
                printer.add('-');
                j++;
            }
            else if(i <= n){
                stack.push(i);
                printer.add('+');
                i++;
            }
            else {
                System.out.println("NO");
                return;
            }
        }


        for(char a : printer) {
            System.out.println(a);
        }

    }
}