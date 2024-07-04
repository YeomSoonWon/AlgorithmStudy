import java.util.Scanner;

public class BOJ2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for(int i = 1 ; i<=N ; i++) {
            for(int j = N ; j>i ; j--) {
                sb.append(" ");
            }
            for(int k = 0 ; k<i ; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}
