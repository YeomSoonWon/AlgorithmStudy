import java.util.Arrays;
import java.util.Scanner;

public class BOJ2448 {
    static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        star = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        stars(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
        sc.close();
    }

    private static void stars(int r, int c, int N) {
        if (N == 3) {
            star[r][c] = '*';
            star[r + 1][c - 1] = star[r + 1][c + 1] = '*';
            star[r + 2][c - 2] = star[r + 2][c - 1] = star[r + 2][c] = star[r + 2][c + 1] = star[r + 2][c + 2] = '*';
            return;
        }

        else {
            int cur = N / 2;
            stars(r, c, cur);
            stars(r + cur, c - cur, cur);
            stars(r + cur, c + cur, cur);
        }
    }
}
