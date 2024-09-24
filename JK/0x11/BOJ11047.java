import java.util.Scanner;

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            count += (K / arr[N - i - 1]);
            K %= arr[N - i - 1];
        }
        System.out.println(count);
        sc.close();
    }
}