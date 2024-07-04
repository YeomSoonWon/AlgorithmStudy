import java.util.Scanner;

public class BOJ2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            for(int k = N-i ; k<N ; k++) {
                sb.append(' ');
            }
            for(int j = 0 ; j<2*(N-i)-1 ; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        for(int i = 1 ; i<N ; i++) {
            for(int j = i ; j<N-1 ; j++) {
                sb.append(' ');
            }

            for(int k = 0; k<2*i+1 ; k++) {
                sb.append('*');
            }
            sb.append('\n');

        }

        System.out.println(sb);

        sc.close();
    }
}
