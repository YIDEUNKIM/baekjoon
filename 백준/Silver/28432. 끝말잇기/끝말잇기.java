

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 출력이 안됨
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String str = input.nextLine();
            list.add(str);
        }

        int m = input.nextInt();
        input.nextLine();

        for(int i=0; i<m; i++) {
            String str = input.nextLine();
            list2.add(str);
        }

        List<String> list1 = list2.stream()
                .filter(old -> list.stream()
                        .noneMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());


            if(n == 1){
            System.out.println(list1.get(0));
            }

            else if(list.get(0).equals("?")){
                char nextStartChar = list.get(1).charAt(0);
                for(int j=0; j<list1.size(); j++){
                    if(list1.get(j).charAt(list1.get(j).length() - 1) == nextStartChar) {
                        System.out.println(list1.get(j));
                        break;
                    }
                }
            }
            else if(list.get(n-1).equals("?")) {
                char lastEndChar = list.get(n-2).charAt(list.get(n-2).length()-1);
                for(int j=0; j<list1.size(); j++){
                    if(list1.get(j).charAt(0) == lastEndChar) {
                        System.out.println(list1.get(j));
                        break;
                    }
                }
            }

            else {
                for(int i=1; i<n-1; i++) {
                    if(list.get(i).equals("?")) {
                        char lastEndChar = list.get(i - 1).charAt(list.get(i - 1).length() - 1);
                        char nextStartChar = list.get(i + 1).charAt(0);
                        for (int j = 0; j < list1.size(); j++) {
                            if (list1.get(j).charAt(0) == lastEndChar && list1.get(j).charAt(list1.get(j).length() - 1) == nextStartChar) {
                                System.out.println(list1.get(j));
                                break;
                            }
                        }
                    }
                }
            }

    }
}