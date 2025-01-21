
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        Queue<Integer> list = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            list.add(i);
        }

        StringBuilder str = new StringBuilder();
        str.append("<");

        for(int i=0; i<n; i++) {
            for(int j=0; j<k-1; j++) {
                list.offer(list.poll());
            }
            str.append(list.poll()+ ", ");
        }
        
        str.deleteCharAt(str.length()-2);
        str.deleteCharAt(str.length()-1);
        str.append(">");
        System.out.println(str.toString());
    }
}