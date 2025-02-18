import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] strArr = new String[n + 1]; // 1-based index
        HashMap<String, Integer> strToIndex = new HashMap<>();

        // n개의 문자열 입력 받아 배열과 해시맵에 저장
        for (int i = 1; i <= n; i++) {
            String word = br.readLine();
            strArr[i] = word;
            strToIndex.put(word, i);
        }

        StringBuilder sb = new StringBuilder();

        // m개의 질의 처리
        for (int i = 0; i < m; i++) {
            String query = br.readLine();

            if (Character.isDigit(query.charAt(0))) {  // 첫 글자가 숫자라면 정수로 변환
                int idx = Integer.parseInt(query);
                sb.append(strArr[idx]).append("\n");
            } else { // 문자열이라면 해시맵에서 인덱스 찾기
                sb.append(strToIndex.get(query)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
