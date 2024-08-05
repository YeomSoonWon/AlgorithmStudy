import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []dx = new int[]{-1,0,1,0};
        int []dy = new int[]{0,-1,0,1};

        //Test 케이스 T 입력
        int T = sc.nextInt();
        int cnt;

        for(int i = 0 ; i<T ; i++) {
            //가로N 세로M 그리고 배추의 갯수 num을 입력받기
            int N = sc.nextInt();
            int M = sc.nextInt();
            int num = sc.nextInt();

            //매번 반복문이 실행될때마다 배추의 위치를 나타내는 board와 방문여부vis 그리고 Queue를 초기화
            int [][]board = new int[N][M];
            boolean [][]vis = new boolean[N][M];
            Queue<int[]> que = new LinkedList<>();

            //BOJ1926의 문제와 매우 똑같음(그림의 갯수 세기)
            for(int j = 0 ; j<num ; j++) {
                int x = sc.nextInt();
                int y= sc.nextInt();
                //배추가 존재하는 곳은 1로 지정
                board[x][y] = 1;
            }

            //항상 count값을 초기화 시키기
            cnt = 0;

            //(j,k)를 Start 지점으로 설정
            for(int j = 0 ; j<N ; j++) {
                for(int k = 0 ; k<M ; k++) {

                    //만약 Start지점이 아닌 곳들은 소거한 후 BFS진행
                    if(board[j][k] != 1 || vis[j][k]) {
                        continue;
                    }

                    //Start지점이 지정되었다면 그림이 1 증가
                    cnt++;
                    que.add(new int[]{j,k});
                    vis[j][k] = true;

                    while(!que.isEmpty()) {
                        int []cur = que.poll();

                        for(int dir = 0 ; dir<4 ; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if(nx<0 || nx>=N || ny<0 || ny>=M) {
                                continue;
                            }
                            if(board[nx][ny] == 1 && !vis[nx][ny]) {
                                
                            que.add(new int[]{nx,ny});
                            vis[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
        sc.close();
     }
}
