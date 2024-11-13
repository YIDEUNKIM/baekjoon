
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String [] winner = new String [n];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int r = input.nextInt();
            int c = input.nextInt();
            if(r == c){
                winner[i] = "dohoon";
            }

            else{
                winner[i] = "jinseo";
                list.add(r>c ? c : r);
                // 각 턴 마다 플레이어는 말을 같은 행의 왼쪽으로
                // 1칸 이상 이동시키거나 같은 열의 위쪽으로 1칸 이상 이동시켜야한다.
            }
        }

        Iterator<Integer> it = list.iterator();
        for(int i=0; i<n; i++){
            System.out.println(winner[i]);
            if(winner[i].equals("jinseo")){
                int rc = it.next();
                System.out.println(rc+" "+rc);
            }
        }


    }

}