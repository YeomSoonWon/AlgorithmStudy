import java.util.Scanner;

public class BOJ1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(func(N, r, c));
        sc.close();
    }

    private static int func(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, n - 1);

        if (r < half && c < half) {
            return func(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return half * half + func(n - 1, r, c - half);
        }

        if (r >= half && c < half) {
            return 2 * half * half + func(n - 1, r - half, c);
        }

        return 3 * half * half + func(n - 1, r - half, c - half);
    }
}
