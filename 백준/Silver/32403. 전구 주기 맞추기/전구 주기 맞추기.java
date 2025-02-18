

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 출력이 안됨
 */
public class Main {

    public static int resultCount = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = input.nextInt();
        int t = input.nextInt();


        int resultCount = 0;
        for (int i = 0; i< n; i++) {
            int a = input.nextInt();
            list.add(a);
        }

        for (int i = 0; i< n; i++) {
            int f = t%list.get(i);
            int value = list.get(i);
            if(f>0) {
                if(list.get(i) > t) {
                    while(true) {
                        value--;
                        resultCount++;
                        if(value == t)
                            break;
                    }
                }
                else {
                    int minusValue = value;
                    int plusValue = value;
                    int minus = 0;
                    int plus = 0;
                    while (true) {
                        minusValue--;
                        minus++;
                        plusValue++;
                        plus++;
                        if(t%minusValue == 0 || t%plusValue == 0) {
                            if(minus < plus) {
                                resultCount += minus;
                                break;
                            }
                            else {
                                resultCount += plus;
                                break;
                            }
                        }
                    }
                }
            }


        }
        
        System.out.println(resultCount);

    }
}