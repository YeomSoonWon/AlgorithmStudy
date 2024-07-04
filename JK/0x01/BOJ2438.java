import java.util.Scanner;

public class BOJ2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            for(int j = 0 ; j<i+1 ; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);

        sc.close();
    }
}
