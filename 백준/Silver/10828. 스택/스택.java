
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());
        Stack<Integer> stack = new Stack<>();



        for (int i=0; i < n; i++){
            String s = sb.readLine();

            if(s.contains("push")){
                int pnum = Integer.parseInt( s.substring(5));
                stack.push(pnum);
            }
            else if(s.equals("pop")){
                System.out.println(stack.empty() ? -1 : stack.pop());
            }
            else if(s.equals("size")){
                System.out.println(stack.size());
            }
            else if(s.equals("empty")){
                System.out.println(stack.empty() ? "1" : "0");
            }
            else if(s.equals("top")){
                System.out.println(stack.empty() ? -1 : stack.peek());
            }
        }
    }
}