import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String ball = input.next();
        
        if(ball.length() != n){
            return;
        }

        long count = 0;
        long result = 0;

        for(int i=0; i<ball.length(); i++) {
            if(ball.charAt(i) == '0'){
                result += (count * (count+1))/2; // like 급수 공식
                count = 0;
            }

            else{
                count ++;
            }
        }
        result += (long)(count * (count+1))/2; // 마지막에 1이 연속되어 있을 때 for문 안에서 if문에서 처리가 안되니 마지막에 더해주기

        System.out.println(result);

    }
}