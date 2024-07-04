import java.util.Scanner;

public class BOJ2441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i = N ; i>0 ; i--) {
            for(int k = i ; k<N ; k++) {
                sb.append(' ');
            }
            for(int j = i ; j>0 ; j--) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        sc.close();
    }
}
