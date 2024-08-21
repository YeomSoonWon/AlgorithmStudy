import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미해결
public class BOJ2146 {
    public static int N;
    public static int[][] board;
    public static boolean[][] vis;
    public static int type = 0;
    public static int cnt = 0;
    public static Queue<int[]> que;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (vis[i][j]) {
                    continue;
                }
                que.add(new int[] { i, j });
                vis[i][j] = true;
                type++;

                while (!que.isEmpty()) {
                    int[] cur = que.poll();
                    board[cur[0]][cur[1]] = type;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                            continue;
                        }
                        if (vis[nx][ny] || board[nx][ny] == 0) {
                            continue;
                        }
                        que.add(new int[] { nx, ny });
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (vis[i][j]) {
                    continue;
                }
                bfs(i, j, board[i][j]);
            }
        }
        sc.close();
        System.out.println(min);
    }

    private static void bfs(int i, int j, int type) {
        que = new LinkedList<>();
        boolean[][] isVis = new boolean[N][N];
        vis[i][j] = true;
        isVis[i][j] = true;

        que.add(new int[] { i, j, 0 });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (board[nx][ny] == type) {
                    vis[nx][ny] = true;
                    continue;
                }
                if (isVis[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    que.add(new int[] { nx, ny, cur[2] + 1 });
                    isVis[nx][ny] = true;
                } else if (board[nx][ny] != type) {
                    min = Math.min(min, cur[2]);
                    return;
                }
            }
        }
    }
}