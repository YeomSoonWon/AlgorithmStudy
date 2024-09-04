import java.util.Scanner;

public class BOJ16987 {
    static int N;
    static int[][] egg;
    static int cnt = 0;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        egg = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                egg[i][j] = sc.nextInt();
            }
        }
        func(0);
        System.out.println(max);
        sc.close();
    }

    private static void func(int d) {
        if (d == N) {
            max = Math.max(max, cnt);
            return;
        }

        if (egg[d][0] <= 0 || cnt == N - 1) {
            func(d + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == d || egg[i][0] <= 0) {
                continue;
            }
            egg[d][0] -= egg[i][1];
            egg[i][0] -= egg[d][1];

            if (egg[d][0] <= 0) {
                cnt++;
            }
            if (egg[i][0] <= 0) {
                cnt++;
            }

            func(d + 1);

            if (egg[d][0] <= 0) {
                cnt--;
            }
            if (egg[i][0] <= 0) {
                cnt--;
            }
            egg[d][0] += egg[i][1];
            egg[i][0] += egg[d][1];
        }
    }
}
