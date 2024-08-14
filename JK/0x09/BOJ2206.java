import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        if (N - 1 == 0 && M - 1 == 0) {
            System.out.println(1);
            sc.close();
            return;
        }

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        char[][] board = new char[N][M];
        int[][] dist = new int[N][M];
        boolean[][][] vis = new boolean[2][N][M];

        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        que.add(new int[] { 0, 0, 0 });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (board[nx][ny] == '1') {
                    if (!vis[1][nx][ny] && cur[2] == 0) {
                        vis[cur[2]][nx][ny] = true;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        que.add(new int[] { nx, ny, 1 });
                    }
                } else {
                    if (!vis[cur[2]][nx][ny]) {
                        vis[cur[2]][nx][ny] = true;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        que.add(new int[] { nx, ny, cur[2] });
                    }
                }
                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(dist[nx][ny] + 1);
                    sc.close();
                    return;
                }
            }
        }

        System.out.println(-1);
        sc.close();
    }
}
