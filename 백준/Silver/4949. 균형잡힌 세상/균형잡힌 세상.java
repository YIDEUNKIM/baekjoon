import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        outer:
        while (input.hasNext()) {
            String line = input.nextLine();
            if (line.charAt(0) == '.')
                break;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);

                if (current == '(' || current == '[') {
                    stack.push(current);
                } else if (current == ')') {
                    // stack.pop()을 하면 stack의 top이 반환된다.
                    // 4번 라인 테스트 케이스에서 "("가 반환되는 것이 아닌 "["이 반환되므로
                    // "no" 출력
                    if (stack.isEmpty() || stack.pop() != '(') {
                        System.out.println("no");
                        continue outer;
                    }
                } else if (current == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        System.out.println("no");
                        continue outer;
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}