import java.util.Scanner;

public class BOJ15650 {
    static int N, M;
    static int[] arr = new int[10];
    static boolean[] chk = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        func(0, 1);

        sc.close();
    }

    private static void func(int k, int j) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = j; i <= N; i++) {
            if (!chk[i]) {
                arr[k] = i;
                chk[i] = true;
                func(k + 1, i + 1);
                chk[i] = false;
            }
        }
    }
}
