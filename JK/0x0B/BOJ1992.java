
//미해결
import java.util.Scanner;

public class BOJ1992 {
    static StringBuilder sb;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

    }
}
