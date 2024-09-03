import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ15666 {
    static int N, M;
    static int[] arr;
    static int[] chk;
    static HashSet<String> set = new HashSet<>();

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

        func(0, 0);
        sc.close();
    }

    private static void func(int d, int start) {
        if (d == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(chk[i] + " ");
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                System.out.println(sb.toString());
            }
            return;
        }

        for (int i = start; i < N; i++) {
            chk[d] = arr[i];
            func(d + 1, i);
        }
    }
}
