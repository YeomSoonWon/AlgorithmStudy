import java.util.Arrays;
import java.util.Scanner;

public class BOJ15656 {
    static int N, M;
    static int[] arr;
    static int[] chk;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        chk = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        func(0);
        System.out.println(sb);
        sc.close();
    }

    private static void func(int d) {
        if (d == M) {
            for (int i = 0; i < M; i++) {
                sb.append(chk[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            chk[d] = arr[i];
            func(d + 1);
        }
    }
}
