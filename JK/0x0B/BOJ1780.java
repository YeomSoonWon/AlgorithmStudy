import java.util.Scanner;

public class BOJ1780 {
    static int N;
    static int[][] board;
    static int[] cnt = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        recur(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
        sc.close();
    }

    private static void recur(int x, int y, int z) {
        if (chk(x, y, z)) {
            cnt[board[x][y] + 1]++;
            return;

        }

        int n = z / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recur(x + (i * n), y + (j * n), n);
            }
        }
    }

    private static boolean chk(int x, int y, int z) {
        for (int i = x; i < x + z; i++) {
            for (int j = y; j < y + z; j++) {
                if (board[i][j] != board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
