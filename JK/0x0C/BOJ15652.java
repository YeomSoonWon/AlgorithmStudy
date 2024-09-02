import java.util.Scanner;

public class BOJ15652 {
    static int N, M;
    static int[] arr = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        func(0, 1);
        sc.close();
    }

    private static void func(int d, int start) {
        if (d == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[d] = i;
            func(d + 1, i);
        }
    }
}
