import java.util.Scanner;

public class BOJ6603 {
    static int N;
    static int[] arr;
    static int[] chk;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                break;
            }
            arr = new int[N];
            chk = new int[N];
            vis = new boolean[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            func(0, 0);
            System.out.println();
        }
        sc.close();
    }

    private static void func(int d, int start) {
        if (d == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(chk[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!vis[i]) {
                chk[d] = arr[i];
                vis[i] = true;
                func(d + 1, i + 1);
                vis[i] = false;
            }
        }
    }
}
