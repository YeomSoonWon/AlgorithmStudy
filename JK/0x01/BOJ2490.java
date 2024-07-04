import java.util.Scanner;

public class BOJ2490 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<3 ; i++) {
            int sum = 0;
            
            for(int j = 0 ; j<4 ; j++) {
                sum += sc.nextInt();
            }

            if(sum == 4) {
                sb.append('E').append('\n');
            }
            else if(sum==3) {
                sb.append('A').append('\n');
            }
            else if(sum==2) {
                sb.append('B').append('\n');
            }
            else if(sum==1) {
                sb.append('C').append('\n');
            }
            else {
                sb.append('D').append('\n');
            }
        }

        sc.close();
        System.out.println(sb);
    }
}
