

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int [] trash = new int[7];

        ArrayList<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list.add(input.next());
        }
        map.put('P', input.nextInt());
        map.put('C', input.nextInt());
        map.put('V', input.nextInt());
        map.put('S', input.nextInt());
        map.put('G', input.nextInt());
        map.put('F', input.nextInt());
        map.put('O', input.nextInt());

        long result = 0;
        loop1 :
        for(int i=0; i<n; i++) {
            boolean done = false;
            loop2:
            for(int j=0; j<list.get(i).length()-1; j++) {
                if(list.get(i).charAt(j) != list.get(i).charAt(j+1)) {
                    result += (long)list.get(i).length() * map.get('O');
                    done = true;
                    break loop2;
                }
            }
            if(!done) {
                if(map.get(list.get(i).charAt(0)) <= map.get('O')){
                    result += (long)list.get(i).length() * map.get(list.get(i).charAt(0));
                }
                else
                    result += (long)list.get(i).length() * map.get('O');
            }
        }
        System.out.println(result);


    }
}