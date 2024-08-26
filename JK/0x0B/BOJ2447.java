import java.util.Scanner;

public class BOJ2447 {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new char[N][N];

        sc.close();

        star(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void star(int x, int y, int z) {
        if (z == 1) {
            arr[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                star(x + (i * (z / 3)), y + (j * (z / 3)), z / 3);
            }
        }
    }
}
