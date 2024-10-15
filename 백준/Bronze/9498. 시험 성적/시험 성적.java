import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        if(89 < a )
            System.out.println("A");
        else if (79<a)
            System.out.println("B");
        else if (69<a)
                System.out.println("C");
        else if (59 < a)
                    System.out.println("D");


        else
            System.out.println("F");


    }
}