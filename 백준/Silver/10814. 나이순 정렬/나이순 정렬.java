import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 테스트케이스 수
        List<People> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new People(age, name, i)); // 입력 순서를 저장하기 위해 인덱스 추가
        }

        // 정렬: 나이순, 그리고 입력 순서 유지
        Collections.sort(list);

        // 결과 출력
        for (People person : list) {
            System.out.println(person.age + " " + person.name);
        }
    }
}

class People implements Comparable<People> {
    int age;
    String name;
    int index; // 입력 순서

    public People(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }

    @Override
    public int compareTo(People o) {
        if (this.age != o.age) {
            return this.age - o.age; // 나이 오름차순 정렬
        }
        return this.index - o.index; // 나이가 같으면 입력 순서 유지
    }
}
