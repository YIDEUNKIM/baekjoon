

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        while (T-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();

            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                q.offer(new int[] {i, in.nextInt()});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                boolean hasHigher = q.stream().anyMatch(doc -> doc[1] > curr[1]);

                if (hasHigher) {
                    q.offer(curr);
                } else {
                    count++;
                    if (curr[0] == M) {
                        break;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}