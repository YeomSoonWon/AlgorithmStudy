import java.util.Scanner;

public class BOJ1629 {
    public static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(pow(A, B));
        sc.close();
    }

    private static long pow(long A, long B) {
        if (B == 1) {
            return A % C;
        }
        long val = pow(A, B / 2);
        val = val * val % C;
        if (B % 2 == 0) {
            return val;
        }
        return val * A % C;
    }
}