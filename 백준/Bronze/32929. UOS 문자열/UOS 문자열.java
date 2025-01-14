

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int f = n%3;
        
        if(f==0)
            System.out.println("S");
        else if (f == 1)
            System.out.println("U");
        else if (f==2)
            System.out.println("O");
        
    }
}