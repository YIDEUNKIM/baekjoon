

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 테스트케이스 수
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for (String factor : solve(str)) {
            System.out.println(factor);
        }
    }

    public static String[] solve(String[] str) {
        // 1. 대문자와 숫자 제거
        List<String> filteredList = new ArrayList<>();
        for (String s : str) {
            char firstChar = s.charAt(0);
            if ('a' <= firstChar && firstChar <= 'z') { // 소문자로 시작하는 문자열만 추가
                if(!filteredList.contains(s)) {
                    filteredList.add(s);
                }
            }
        }

        // 2. 문자열 정렬
        // - 길이가 짧은 순서대로
        // - 길이가 같으면 사전 순으로
        filteredList.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            else {
                return s1.compareTo(s2); // 사전 순 비교
            }
        });



        // 3. 결과 반환
        return filteredList.toArray(new String[0]);
    }
}
