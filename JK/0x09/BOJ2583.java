import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2583 {
    public static void main(String[] args) {
        int cnt = 0;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        Queue<int[]> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int K = sc.nextInt();

        boolean[][] board = new boolean[N][M];
        boolean[][] vis = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    board[j][k] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] || vis[i][j]) {
                    continue;
                }

                cnt++;
                que.add(new int[] { i, j });
                vis[i][j] = true;

                int area = 0;

                while (!que.isEmpty()) {
                    area++;
                    int[] cur = que.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }
                        if (board[nx][ny] || vis[nx][ny]) {
                            continue;
                        }

                        vis[nx][ny] = true;
                        que.add(new int[] { nx, ny });
                    }
                }
                list.add(area);
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        sc.close();
    }
}
