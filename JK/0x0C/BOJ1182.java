import java.util.Scanner;

public class BOJ1182 {
    static int N, S;
    static int[] arr = new int[30];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        func(0, 0);

        if (S == 0) {
            cnt--;
        }
        System.out.println(cnt);
        sc.close();
    }

    private static void func(int k, int sum) {
        if (k == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        func(k + 1, sum + arr[k]);
        func(k + 1, sum);
    }
}