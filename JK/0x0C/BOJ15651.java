import java.util.Scanner;

public class BOJ15651 {
    static int N, M;
    static int[] arr = new int[10];
    static boolean[] chk = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        func(0);
        System.out.println(sb);
        sc.close();
    }

    private static void func(int d) {
        if (d == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[d] = i;
            func(d + 1);
        }
    }
}
