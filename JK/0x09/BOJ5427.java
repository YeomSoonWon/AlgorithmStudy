import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미해결 
public class BOJ5427 {
    public static int w;
    public static int h;
    public static char[][] board;
    public static int[][] timeF;
    public static int[][] timeE;
    public static Queue<int[]> queF;
    public static Queue<int[]> queE;
    public static int[] dx = { 1, -1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            w = sc.nextInt();
            h = sc.nextInt();

            board = new char[h][w];
            timeF = new int[h][w];
            timeE = new int[h][w];
            queF = new LinkedList<>();
            queE = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String str = sc.next();
                for (int k = 0; k < w; k++) {
                    board[j][k] = str.charAt(k);
                    timeE[j][k] = -1;
                    timeF[j][k] = -1;

                    if (board[j][k] == '*') {
                        queF.add(new int[] { j, k });
                        timeF[j][k] = 0;
                    }
                    if (board[j][k] == '@') {
                        queE.add(new int[] { j, k });
                        timeE[j][k] = 0;
                    }
                }
            }

            bfsF();
            bfsE();
        }
        System.out.println(sb);
        sc.close();
    }

    private static void bfsE() {
        while (!queE.isEmpty()) {
            int[] cur = queE.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    sb.append(timeE[cur[0]][cur[1]] + 1).append('\n');
                    return;
                }
                if (timeE[nx][ny] != -1 || board[nx][ny] == '#') {
                    continue;
                }
                if (timeF[nx][ny] != -1 && timeE[cur[0]][cur[1]] + 1 >= timeF[nx][ny]) {
                    continue;
                }

                queE.add(new int[] { nx, ny });
                timeE[nx][ny] = timeE[cur[0]][cur[1]] + 1;
            }
        }
        sb.append("IMPOSSIBLE").append('\n');
    }

    private static void bfsF() {
        if (queF.isEmpty()) {
            return;
        } else {

            while (!queF.isEmpty()) {
                int[] cur = queF.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }
                    if (board[nx][ny] == '#' || board[nx][ny] == '*' || timeF[nx][ny] != -1) {
                        continue;
                    }

                    queF.add(new int[] { nx, ny });
                    timeF[nx][ny] = timeF[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}