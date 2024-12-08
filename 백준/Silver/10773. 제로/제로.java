
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int k = input.nextInt();
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for(int i=0; i<k; i++){
            int n = input.nextInt();
            if(n == 0)
                stack.pop();
            else if(n > 0)
            stack.push(n);
        }

        for(int i=0; i<stack.size(); i++){
            count += stack.get(i);
        }

        System.out.println(count);



    }
}