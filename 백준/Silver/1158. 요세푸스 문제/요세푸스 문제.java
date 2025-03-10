
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int n = input.nextInt();
        int k = input.nextInt();

        for(int i=0; i<n; i++) {
            q.add(i+1);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int x = q.poll();
            count++;
            if(count == k){
                list.add(x);
                count = 0;
            }
            else
                q.add(x);

        }



        System.out.print("<");
        for(int i=0; i<n-1; i++)
            System.out.print(list.get(i)+", ");
        System.out.print(list.get(n-1)+">");
    }
}