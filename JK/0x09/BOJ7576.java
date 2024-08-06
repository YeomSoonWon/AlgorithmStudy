import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int [][] board;
        int [][] day;
        int []dx = new int[]{-1,0,1,0};
        int []dy = new int[]{0,-1,0,1};

        Queue<int[]> que = new LinkedList<>();


        int M = sc.nextInt();
        int N = sc.nextInt();

        board = new int[N][M];
        day = new int[N][M];

        //board에 토마토의 존재 여부 저장 및 토마토가 익은 곳은 Queue에 미리 저장 그리고 익지 않은곳(존재X 아님)은 day를 -1로 주어 방문 여부 설정
        for(int i = 0 ; i<N ; i++) {
            for(int j = 0 ; j<M ; j++) {
                int num = sc.nextInt();
                board[i][j] = num;
                if(num == 1) {
                    que.add(new int[]{i,j});
                }
                if(num == 0) {
                    day[i][j] = -1;
                }
            }
        }

        while(!que.isEmpty()) {
            int []cur = que.poll();

            for(int dir = 0 ; dir<4 ; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx<0 || nx>=N || ny<0 || ny>=M) {
                    continue;
                }
                //방문했더라면 pass
                if(day[nx][ny] != -1) {
                    continue;
                }
                
                //익지 않은 곳은 익은 곳의 근처에서 1일이 추가 되고 토마토가 익어야 한다
                day[nx][ny] = day[cur[0]][cur[1]] + 1;
                que.add(new int[]{nx,ny});
            }
        }
        //날의 최대치 설정
        int max = 0;

        for(int i = 0 ; i<N ; i++) {
            for(int j = 0 ; j<M ; j++) {
                //만약 익지 않은 곳에 한 번도 방문하지 않았더라면 -1 출력
                if(day[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                //모두 정상적으로 작동했으면 날의 최대치를 max에 저장
                max = Math.max(max , day[i][j]);
            }
        }  
        System.out.println(max);
    }
}
