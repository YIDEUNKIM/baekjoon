

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        input.nextLine(); 

        for (int t = 0; t < T; t++) {
            String expression = input.nextLine();
            int result = calculateExpression(expression);
            System.out.println(result);
        }

        input.close();
    }

    public static int calculateExpression(String exp) {
        int a = 0; 
        int b = 0; 
        int n = -1; 
        
        int i = 0;
        while (i < exp.length() && exp.charAt(i) == '!') {
            a++;
            i++;
        }
        
        n = Character.getNumericValue(exp.charAt(i));
        i++;
       
        while (i < exp.length() && exp.charAt(i) == '!') {
            b++;
            i++;
        }

       
        int result = n;
        
        for (int j = 0; j < b; j++) {
            result = factorial(result);
        }
        
        for (int j = 0; j < a; j++) {
            result = logicalNot(result);
        }

        return result;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n; 
    }

    public static int logicalNot(int n) {
        return (n == 0) ? 1 : 0;
    }
}