
import java.util.*;

/**
 * 찐 Even Number
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] list = new int[5];
        list[0] = input.nextInt();
        list[1] = input.nextInt();
        list[2] = input.nextInt();
        list[3] = input.nextInt();
        list[4] = input.nextInt();

        Arrays.sort(list);
        
        if(list[0] == list[1] && list[2] == list[3]) {
            System.out.println(list[4]);
        }
        else if(list[0] == list[2] && list[1] == list[3]) {
            System.out.println(list[4]);
        }
        else if(list[0] == list[3] && list[1] == list[3]) {
            System.out.println(list[4]);
        }

        else if(list[0] == list[4] && list[2] == list[3]) {
            System.out.println(list[1]);
        }
        else if(list[0] == list[2] && list[4] == list[3]) {
            System.out.println(list[1]);
        }
        else if(list[0] == list[3] && list[2] == list[4]) {
            System.out.println(list[1]);
        }

        else if(list[0] == list[4] && list[1] == list[3]) {
            System.out.println(list[2]);
        }
        else if(list[0] == list[1] && list[4] == list[3]) {
            System.out.println(list[2]);
        }
        else if(list[0] == list[3] && list[1] == list[4]) {
            System.out.println(list[2]);
        }

        else if(list[0] == list[4] && list[1] == list[2]) {
            System.out.println(list[3]);
        }
        else if(list[0] == list[1] && list[4] == list[2]) {
            System.out.println(list[3]);
        }
        else if(list[0] == list[2] && list[1] == list[4]) {
            System.out.println(list[3]);
        }

        else if(list[3] == list[4] && list[1] == list[2]) {
            System.out.println(list[0]);
        }
        else if(list[3] == list[1] && list[4] == list[2]) {
            System.out.println(list[0]);
        }
        else if(list[3] == list[2] && list[1] == list[4]) {
            System.out.println(list[0]);
        }


    }
}