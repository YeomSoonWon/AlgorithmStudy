import java.util.Scanner;

public class BOJ15649 {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] chk = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        func(0);
        sc.close();
    }

    private static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!chk[i]) {
                arr[k] = i;
                chk[i] = true;
                func(k + 1);
                chk[i] = false;
            }
        }
    }
}
