
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());
        Queue<Integer> stack = new LinkedList<>();

        for (int i=0; i < n; i++){
            String s = sb.readLine();

            if(s.contains("push")){
                int pnum = Integer.parseInt( s.substring(5));
                stack.offer(pnum);
            }
            else if(s.equals("pop")){
                System.out.println(stack.isEmpty() ? -1 : stack.poll());
            }
            else if(s.equals("size")){
                System.out.println(stack.size());
            }
            else if(s.equals("empty")){
                System.out.println(stack.isEmpty() ? "1" : "0");
            }
            else if(s.equals("front")){
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
            else if(s.equals("back")){
                System.out.println(stack.isEmpty() ? -1 : stack.toArray()[stack.size()-1]);
            }
        }
    }
}