import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //그림의 갯수를 세기 위한 cnt , 그림 하나의 크기를 세기 위한 area , 그리고 area의 최댓값을 저장하기 위한 max값 설정
        int cnt = 0;
        int area = 0;
        int max = 0;

        //입력받은 것을 중심으로 상,하,좌,우를 탐색하기 위해 dx와dy설정
        int dx[] = new int[] { 1, 0, -1, 0 };
        int dy[] = new int[] { 0, 1, 0, -1 };

        //Queue에 위치를 저장하기 위해 배열을 입력받기
        Queue<int[]> que = new LinkedList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        //그림판을 나타내기 위한 board , 방문 여부를 나타내기 위한 vis 배열 설정
        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //위치 (i,j) 에서 시작점이라면 아래를 시행하고 그렇지 않다면 pass하는 형식
                if (board[i][j] == 0 || vis[i][j]) {
                    continue;
                }

                //시행을 시작하고 나면 시작점이 정해졌으므로 그림이 하나 추가된다(따라서 cnt가 1 증가)
                cnt++;

                //그리고 예외없이 (i,j)도 방문하고 그림의 크기에 포함된다
                que.add(new int[] { i, j });
                vis[i][j] = true;

                //area는 항상 초기화
                area = 0;

                //Queue에서 제거해가면서 방문을 확인하므로 Queue가 비는 순간 그림이 끊긴다는 것
                while (!que.isEmpty()) {
                    //한 칸 이동했다면 area 1 증가
                    area++;

                    //Queue에서 하나의 위치를 제거하고 그것을 참조하여 상하좌우 판단
                    int[] cur = que.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        //범위에서 벗어나서 오류가 나는것을 방지
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }

                        //입력받은 칸이 색칠되어있고 전에 방문하지 않았다면 Queue에 넣어주고 방문 체크
                        if (board[nx][ny] == 1 && !vis[nx][ny]) {
                            vis[nx][ny] = true;
                            que.add(new int[] { nx, ny });
                        }
                    }
                }
                //이렇게 입력받은 area값과 max값을 비교하여 큰 값을 max로 저장
                max = Math.max(max, area);
            }
        }

        System.out.println(cnt);
        System.out.println(max);
        sc.close();

    }

}