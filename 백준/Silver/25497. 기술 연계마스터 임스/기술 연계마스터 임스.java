
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();

        for (int i = 0; i < n; i++) {
            queue.add(s.charAt(i));
        }

        long result = 0;
        int scnt = 0;
        int lcnt = 0;
        int kcnt = 0;
        int rcnt = 0;
        for (int i = 0; i < n; i++) {
            char current = queue.poll();
            if (String.valueOf(current).matches("[1-9]")) {
                result++;
            }
            else if (current == 'S') {
                scnt++;
            }
            else if (current == 'L') {
                lcnt++;
            }
            else if (current == 'K') {
                kcnt++;
                if (scnt > 0 && rcnt ==0) {
                    scnt--;
                    kcnt--;
                    result++;
                }
                else if (rcnt == 0) {
                    break;
                }
            }
            else if (current == 'R') {
                rcnt++;
                if (lcnt > 0 && kcnt == 0) {
                    lcnt--;
                    rcnt--;
                    result++;
                }
                else if (lcnt == 0) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}