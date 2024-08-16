import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2573 {
    public static int[][] board;
    public static boolean[][] vis;
    public static Queue<int[]> que;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int cnt = 0;
    public static int year = 0;
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        board = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();

        while (true) {
            bfs();

            if (cnt > 1) {
                System.out.println(year);
                return;
            }

            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            icemelt();
        }
    }

    private static void bfs() {
        cnt = 0;
        vis = new boolean[N][M];

        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0 || vis[i][j]) {
                    continue;
                }
                que.add(new int[] { i, j });
                vis[i][j] = true;
                cnt++;

                while (!que.isEmpty()) {
                    int[] cur = que.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }
                        if (board[nx][ny] == 0 || vis[nx][ny]) {
                            continue;
                        }

                        que.add(new int[] { nx, ny });
                        vis[nx][ny] = true;

                    }
                }
            }
        }
    }

    private static void icemelt() {
        vis = new boolean[N][M];
        year++;
        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    que.add(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == 0 && board[cur[0]][cur[1]] > 0) {
                    board[cur[0]][cur[1]]--;
                }
            }
        }
    }
}
