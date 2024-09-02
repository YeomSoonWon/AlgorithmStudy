import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657 {
    static int N, M;
    static int[] arr;
    static int[] chk;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        chk = new int[N];
        vis = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        func(0, 0);
        sc.close();
    }

    private static void func(int d, int start) {
        if (d == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(chk[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            chk[d] = arr[i];
            func(d + 1, i);
        }
    }
}
