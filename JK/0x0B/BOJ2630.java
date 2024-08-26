import java.util.Scanner;

public class BOJ2630 {
    static int[][] board;
    static int N;
    static int[] arr = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        sc.close();

        recur(0, 0, N);

        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }

    private static void recur(int x, int y, int z) {
        if (chk(x, y, z)) {
            arr[board[x][y]]++;
            return;
        }

        int n = z / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
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
