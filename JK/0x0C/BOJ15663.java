import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ15663 {
    static int N, M;
    static int[] arr;
    static int[] chk;
    static boolean[] vis;
    static HashSet<String> set = new HashSet<>();

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

        func(0);
        sc.close();
    }

    private static void func(int d) {
        if (d == M) {
            StringBuilder sbi = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sbi.append(chk[i] + " ");
            }
            String str = sbi.toString();
            if (!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                chk[d] = arr[i];
                vis[i] = true;
                func(d + 1);
                vis[i] = false;
            }
        }
    }
}
