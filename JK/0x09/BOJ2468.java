import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2468 {
    public static int N;
    public static int[][] board;
    public static boolean[][] vis;
    public static int[][] map;
    public static Queue<int[]> que;
    public static HashSet<Integer> list;
    public static int cnt;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int max = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        list = new HashSet<>();
        board = new int[N][N];
        vis = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                list.add(board[i][j]);
            }
        }

        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            que = new LinkedList<>();
            cnt = 0;
            vis = new boolean[N][N];
            map = new int[N][N];

            int rain = iter.next();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] > rain) {
                        map[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 || vis[i][j]) {
                        continue;
                    }
                    cnt++;
                    que.add(new int[] { i, j });
                    vis[i][j] = true;

                    while (!que.isEmpty()) {
                        int[] cur = que.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }
                            if (vis[nx][ny] || map[nx][ny] == 0) {
                                continue;
                            }

                            que.add(new int[] { nx, ny });
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);
        sc.close();
    }
}
