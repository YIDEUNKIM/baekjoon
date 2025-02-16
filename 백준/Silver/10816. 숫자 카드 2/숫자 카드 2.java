import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 번째 줄: 숫자 카드의 개수 N
        int n = Integer.parseInt(br.readLine());

        // 카드 목록 입력
        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 카드 정렬
        Arrays.sort(cards);

        // 두 번째 줄: 몇 개의 수 M이 있는지
        int m = Integer.parseInt(br.readLine());

        // M개의 숫자 입력
        st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        
        // 각 질의에 대해 카드 개수 찾기
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(st.nextToken());

            // 이진 탐색을 통해 해당 카드의 개수 계산
            int leftIndex = lowerBound(cards, query);
            int rightIndex = upperBound(cards, query);
            
            result.append(rightIndex - leftIndex).append(" ");
        }

        // 결과 출력
        System.out.println(result.toString().trim());
    }

    // lowerBound: 해당 값이 처음 등장하는 인덱스를 찾는 이진 탐색
    public static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

    // upperBound: 해당 값이 마지막으로 등장하는 인덱스를 찾는 이진 탐색
    public static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
