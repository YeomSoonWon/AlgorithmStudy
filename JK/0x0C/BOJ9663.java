import java.util.Scanner;

public class BOJ9663 {
    static int N;
    static int cnt = 0;
    static boolean[] chk1 = new boolean[40];
    static boolean[] chk2 = new boolean[40];
    static boolean[] chk3 = new boolean[40];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        func(0);

        System.out.println(cnt);
        sc.close();
    }

    private static void func(int cur) {
        if (cur == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (chk1[i] || chk2[i + cur] || chk3[cur - i + N - 1]) {
                continue;
            }

            chk1[i] = true;
            chk2[i + cur] = true;
            chk3[cur - i + N - 1] = true;

            func(cur + 1);
            chk1[i] = false;
            chk2[i + cur] = false;
            chk3[cur - i + N - 1] = false;
        }

    }
}
