import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 입출력
        int n = input.nextInt();
        System.out.println(test(n));

    }

    public static int test(int n) {

        for(int i=0; i<n; i++){
            //삼각수 조건
            if(6*( i *(i+1)/2)+1<n && n <=(6*( (i + 1) *(i+2)/2))+1){
                return i+2;
            }

        }
        return 1;
    }
}
