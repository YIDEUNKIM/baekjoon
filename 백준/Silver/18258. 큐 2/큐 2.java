

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();

        for (int i=0; i < n; i++){
            String s = sb.readLine();

            if(s.contains("push")){
                int pnum = Integer.parseInt( s.substring(5));
                stack.add(pnum);
            }
            else if(s.equals("pop")){
                str.append(stack.isEmpty() ? -1 : stack.poll()).append("\n");
            }
            else if(s.equals("size")){
                str.append(stack.size()).append("\n");
            }
            else if(s.equals("empty")){
                str.append(stack.isEmpty() ? "1" : "0").append("\n");
            }
            else if(s.equals("front")){
                str.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
            else if(s.equals("back")){
                str.append(stack.isEmpty() ? -1 : stack.peekLast()).append("\n");
            }
        }
        System.out.println(str);
    }
}