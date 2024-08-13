import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ5014 {
    public static Queue<Integer> que;
    public static int F;
    public static int S;
    public static int G;
    public static int U;
    public static int D;
    public static int[] board;
    public static boolean[] vis;
    public static int[] dx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        que = new LinkedList<>();

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        dx = new int[] { U, -D };

        board = new int[F + 1];
        vis = new boolean[F + 1];

        que.add(S);
        vis[S] = true;

        bfs();
        sc.close();

    }

    private static void bfs() {
        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == G) {
                System.out.println(board[cur]);
                return;
            }
            for (int dir = 0; dir < 2; dir++) {
                int nx = cur + dx[dir];

                if (nx > F || nx < 1) {
                    continue;
                }
                if (vis[nx]) {
                    continue;
                }

                vis[nx] = true;
                que.add(nx);
                board[nx] = board[cur] + 1;
            }
        }
        System.out.println("use the stairs");
    }
}
