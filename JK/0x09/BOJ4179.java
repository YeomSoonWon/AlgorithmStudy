
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ4179 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //불이 이동하는 경로와 지훈이가 이동하는 경로를 나눠서 설정
        Queue<int[]> que1 = new LinkedList<>();
        Queue<int[]> que2 = new LinkedList<>();
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, -1, 0, 1 };

        int N = sc.nextInt();
        int M = sc.nextInt();

        //불이 이동하는 시간과 지훈이가 이동하는 시간 설정
        int[][] time1 = new int[N][M];
        int[][] time2 = new int[N][M];
        //미로는 똑같으므로 공유
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                //모든 공간에 방문여부를 나타내기 위해 -1로 지정
                board[i][j] = line.charAt(j);
                time1[i][j] = -1;
                time2[i][j] = -1;

                //불과 지훈이의 시작점은 항상 0에서 출발하므로 설정해주고 각각의 Queue에 저장
                if (board[i][j] == 'F') {
                    que1.add(new int[] {i,j});
                    time1[i][j] = 0;
                }
                if (board[i][j] == 'J') {
                    que2.add(new int[] {i,j});
                    time2[i][j] = 0;
                }
            }
        }

        //우선 불의 이동경로와 시간을 설정해주고 지훈이의 시간을 확인해가며 답을 구하기
        while (!que1.isEmpty()) {
            int[] cur1 = que1.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur1[0] + dx[dir];
                int ny = cur1[1] + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (time1[nx][ny] >= 0 || board[nx][ny] == '#') {
                    continue;
                }

                time1[nx][ny] = time1[cur1[0]][cur1[1]] + 1;
                que1.add(new int[]{nx,ny});
            }
        }

        while (!que2.isEmpty()) {
            int[] cur2 = que2.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur2[0] + dx[dir];
                int ny = cur2[1] + dy[dir];

                //만약 지훈이의 현재의 위치가 미로 밖을 벗어났더라면 탈출했으므로 출력
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    System.out.println(time2[cur2[0]][cur2[1]] + 1);
                    return;
                }
                if (time2[nx][ny] >= 0 || board[nx][ny] == '#') {
                    continue;
                }
                //하지만 불이 옮겨간 시간보다 지훈이가 시간을 더 많이 썼더라면 갈 수 없는 경로가 됨
                if (time1[nx][ny] != -1 && time1[nx][ny] <= time2[cur2[0]][cur2[1]] + 1) {
                    continue;
                }

                que2.add(new int[]{nx,ny});
                time2[nx][ny] = time2[cur2[0]][cur2[1]] + 1;
            }
        }
        //앞에서 지훈이가 탈출하지 못했다면 IMPOSSIBLE 출력
        System.out.println("IMPOSSIBLE");
        sc.close();
    }
}
