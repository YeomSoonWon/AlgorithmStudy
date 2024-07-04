import java.util.Scanner;

public class BOJ2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            for(int j = 0 ; j<N-i-1 ; j++) {
                sb.append(' ');
            }
            for(int k = 1 ; k<=2*i+1 ; k++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        for(int i = N-1 ; i>0 ; i--) {
            for(int j = N-i ; j>0 ; j--) {
                sb.append(' ');
            }
            for(int k = 0 ; k<2*i-1 ; k++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        sc.close();
    }
}
