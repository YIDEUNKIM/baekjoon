
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(input.next());
        }

        for (int j=0; j < n-1; j++) {
            list1.add(input.next());
        }

        for(int i=0; i<n; i++){
            boolean done = false;
            for(int j=0; j< n-1; j++){
                if(list.get(i).equals(list1.get(j))){
                    done = true;
                    break;
                }
            }
            if(!done){
                System.out.println(list.get(i));
                break;
            }
        }
    }
}