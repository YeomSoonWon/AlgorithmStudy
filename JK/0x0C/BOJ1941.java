import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1941 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int cnt = 0;
    static char[][] board = new char[5][5];
    static int[] chk = new int[7];
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        func(0, 0, 0);
        System.out.println(cnt);
        sc.close();
    }

    private static void func(int d, int start, int cntS) {
        if (d - cntS > 3) {
            return;
        }

        if (d == 7) {
            vis = new boolean[7];
            bfs(chk[0] / 5, chk[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            chk[d] = i;
            if (board[i / 5][i % 5] == 'S') {
                func(d + 1, i + 1, cntS + 1);
            } else {
                func(d + 1, i + 1, cntS);
            }
        }
    }

    private static void bfs(int i, int j) {
        int num = 1;
        vis[0] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { i, j });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                int nxt = 5 * nx + ny;
                for (int k = 0; k < 7; k++) {
                    if (!vis[k] && chk[k] == nxt) {
                        vis[k] = true;
                        num++;
                        que.add(new int[] { nx, ny });
                    }
                }
            }
        }
        if (num == 7) {
            cnt++;
        }
    }
}