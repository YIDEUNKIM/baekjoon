import java.util.Scanner;

/**
 * B번 문제
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] key = new String[4];
        char[][] key2 = new char[4][10];
        char [] arr = new char[9];
        int average = 0;
        int avec = 0;

        for (int i = 0; i < 4; i++) {
            key[i] = sc.next();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                key2[i][j] = key[i].charAt(j);
            }
        }


        String str = sc.next();

        for (int j = 0; j < 9; j++) {
            arr[j] = str.charAt(j);
        }

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 10; j++){
                // 행에 마지막 입력 문장과 같은 문자가 3개 이상 들어있는지 검사
                for(int k = 0; k < 9; k++) {
                    if (key2[i][j] == arr[k]) {
                        average += i;
                        avec += j;
                    }
                }
            }
        }

        average = average / 9;
        avec = avec / 9;

        System.out.println(key2[average][avec]);




    }
}

