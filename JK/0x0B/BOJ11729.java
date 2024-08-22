import java.util.Scanner;

public class BOJ11729 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println((int) Math.pow(2, N) - 1);

        hanoi(1, 3, N);
        System.out.println(sb);
        sc.close();
    }

    private static void hanoi(int start, int end, int n) {
        if (n == 1) {
            sb.append(start + " " + end).append('\n');
            return;
        }

        hanoi(start, 6 - start - end, n - 1);
        sb.append(start + " " + end).append('\n');
        hanoi(6 - start - end, end, n - 1);
    }
}
