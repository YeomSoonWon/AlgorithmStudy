import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        Queue<int[]> que = new LinkedList<>();
        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        int N = sc.nextInt();

        int[][] board = new int[N][N];
        boolean[][] vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] || board[i][j] == 0) {
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
                list.add(area);
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        sc.close();
    }
}
