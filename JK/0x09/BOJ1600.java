import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1600 {
    public static int K, W, H;
    public static int[][] board;
    public static boolean[][][] vis;
    public static int[] hdx = { -2, -1, 1, 2, -2, -1, 1, 2 };
    public static int[] hdy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int min = Integer.MAX_VALUE;
    public static Queue<int[]> que;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        H = sc.nextInt();
        W = sc.nextInt();
        board = new int[W][H];
        vis = new boolean[W][H][K + 1];
        que = new LinkedList<>();

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        min = bfs(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
        sc.close();
    }

    private static int bfs(int i, int j) {
        que.add(new int[] { i, j, 0, K });
        vis[i][j][K] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == W - 1 && cur[1] == H - 1) {
                return cur[2];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
                    continue;
                }
                if (board[nx][ny] == 1 || vis[nx][ny][cur[3]]) {
                    continue;
                }

                vis[nx][ny][cur[3]] = true;
                que.add(new int[] { nx, ny, cur[2] + 1, cur[3] });
            }

            if (cur[3] > 0) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur[0] + hdx[dir];
                    int ny = cur[1] + hdy[dir];

                    if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
                        continue;
                    }
                    if (vis[nx][ny][cur[3] - 1] || board[nx][ny] == 1) {
                        continue;
                    }
                    vis[nx][ny][cur[3] - 1] = true;
                    que.add(new int[] { nx, ny, cur[2] + 1, cur[3] - 1 });
                }
            }
        }
        return min;
    }
}
