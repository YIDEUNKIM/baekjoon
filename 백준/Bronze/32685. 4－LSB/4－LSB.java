
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        String [] list = new String[3];
        String n1_bit = Integer.toBinaryString(n1);
        String n2_bit = Integer.toBinaryString(n2);
        String n3_bit = Integer.toBinaryString(n3);

        list[0] = n1_bit;
        list[1] = n2_bit;
        list[2] = n3_bit;

        for(int i=0; i<list.length; i++){
            if(list[i].length() == 3){
                list[i] = "0" + list[i];
            }
            if(list[i].length() == 2){
                list[i] = "00" + list[i];
            }
            if(list[i].length() == 1){
                list[i] = "000" + list[i];
            }
        }
        

             String fourN1 = list[0].substring(list[0].length() - 4);
             String fourN2 = list[1].substring(list[1].length() - 4);
             String fourN3 = list[2].substring(list[2].length() - 4);

            


        int result = Integer.parseInt(fourN1+ fourN2 + fourN3,2) ;
        String jresult = String.valueOf(result);

        if(jresult.length() == 3){
            System.out.println("0"+jresult);
        }
        else if(jresult.length() == 2){
            System.out.println("00"+jresult);
        }
        else if(jresult.length() == 1){
            System.out.println("000"+jresult);
        }
        else
            System.out.println(jresult);


    }
}
