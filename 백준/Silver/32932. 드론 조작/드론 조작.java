

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        int [][] wall = new int[n][2];
        for(int i=0; i<n; i++){
            int x = input.nextInt();
            wall[i][0] = x;
            int y = input.nextInt();
            wall[i][1] = y;
        }

        String s = input.next();
        int [] drone = new int[2];
        drone[0] = 0;
        drone[1] = 0;


        for(int i=0; i<k; i++){
            int nextX = drone[0];
            int nextY = drone[1];
            
            if(s.charAt(i) == 'U')
                nextY++;
            else if(s.charAt(i) == 'D')
                nextY--;
            else if(s.charAt(i) == 'R')
                nextX++;
            else if(s.charAt(i) == 'L')
                nextX--;

            boolean hitwall = false;
            for(int [] wallk : wall) {
                if(nextX == wallk[0] && nextY == wallk[1]){
                    hitwall = true;
                    break;
                }
            }

            if(!hitwall){
                drone[0] = nextX;
                drone[1] = nextY;
            }
        }

        System.out.println(drone[0] +" " + drone[1]);

    }
}