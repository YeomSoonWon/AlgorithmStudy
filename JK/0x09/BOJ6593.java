import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ6593 {
    static public char[][][] board;
    static public int[][][] dist;
    static public Queue<int[]> que = new LinkedList<>();
    static public int[] dx = { -1, 1, 0, 0, 0, 0 };
    static public int[] dy = { 0, 0, -1, 1, 0, 0 };
    static public int[] dz = { 0, 0, 0, 0, -1, 1 };

    static public int L;
    static public int R;
    static public int C;

    static public int endX;
    static public int endY;
    static public int endZ;

    static public StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            board = new char[L][R][C];
            dist = new int[L][R][C];

            que = new LinkedList<>();

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = sc.next();
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = str.charAt(k);
                        dist[i][j][k] = -1;
                        if (board[i][j][k] == 'S') {
                            dist[i][j][k] = 0;
                            que.add(new int[] { i, j, k });
                        }
                        if (board[i][j][k] == 'E') {
                            endX = i;
                            endY = j;
                            endZ = k;
                        }
                    }
                }
            }
            bfs();

        }
        System.out.println(sb);
        sc.close();
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int nz = cur[2] + dz[dir];

                if (nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C) {
                    continue;
                }
                if (board[nx][ny][nz] == '#' || dist[nx][ny][nz] != -1) {
                    continue;
                }

                que.add(new int[] { nx, ny, nz });
                dist[nx][ny][nz] = dist[cur[0]][cur[1]][cur[2]] + 1;
            }
        }

        if (dist[endX][endY][endZ] == -1) {
            sb.append("Trapped!").append('\n');
        } else {
            sb.append("Escaped in " + dist[endX][endY][endZ] + " minute(s).").append('\n');
        }
    }
}
