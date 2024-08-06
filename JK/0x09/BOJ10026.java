import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026 {
    public static Scanner sc = new Scanner(System.in);
    public static int[] dx = new int[] { -1, 0, 1, 0 };
    public static int[] dy = new int[] { 0, -1, 0, 1 };
    public static boolean[][] vis;
    public static boolean[][] Cvis;
    public static char[][] board;
    public static int cnt = 0;
    public static int Ccnt = 0;
    public static int N;

    public static void main(String[] args) throws IOException {

        N = sc.nextInt();

        board = new char[N + 1][N + 1];
        vis = new boolean[N + 1][N + 1];
        Cvis = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!vis[i][j]) {
                    cnt++;
                    bfs1(i, j);
                }

                if (!Cvis[i][j]) {
                    Ccnt++;
                    bfs2(i, j);
                }
            }

        }
        System.out.println(cnt + " " + Ccnt);
    }

    private static void bfs1(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { i, j });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (vis[nx][ny] || board[nx][ny] != board[cur[0]][cur[1]]) {
                    continue;
                }
                vis[nx][ny] = true;
                que.add(new int[] { nx, ny });
            }
        }
    }

    private static void bfs2(int i, int j) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { i, j });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || Cvis[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] == 'R' || board[nx][ny] == 'G') {
                    if (board[cur[0]][cur[1]] == 'B') {
                        continue;
                    }
                }
                if (board[nx][ny] == 'B') {
                    if (board[cur[0]][cur[1]] == 'R' || board[cur[0]][cur[1]] == 'G') {
                        continue;
                    }
                }
                Cvis[nx][ny] = true;
                que.add(new int[] { nx, ny });
            }
        }

    }
}