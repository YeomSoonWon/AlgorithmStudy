import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int []dx = {-1,1,0,0,0,0};
        int []dy = {0,0,-1,1,0,0};
        int []dz = {0,0,0,0,-1,1};

        int M = sc.nextInt();
        int N = sc.nextInt();
        int H = sc.nextInt();

        Queue<int[]> que = new LinkedList<>();

        int [][][]board = new int[M][N][H];
        int [][][]day = new int[M][N][H];

        for(int i = 0 ; i<H ; i++) {
            for(int j = 0 ; j<N ; j++) {
                for(int k = 0 ; k<M ; k++) {
                    board[k][j][i] = sc.nextInt();

                    if(board[k][j][i] == 1) {
                        que.add(new int[]{k,j,i});
                    }
                    if(board[k][j][i] == 0) {
                        day[k][j][i] = -1;
                    }
                }
            }
        }
        sc.close();
        
        while(!que.isEmpty()) {
            int []cur = que.poll();

            for(int dir = 0 ; dir<6 ; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int nz = cur[2] + dz[dir];

                if(nx<0 || nx>=M || ny<0 || ny>=N || nz<0 || nz>=H) {
                    continue;
                }
                if(day[nx][ny][nz] != -1) {
                    continue;
                }

                que.add(new int[]{nx,ny,nz});
                day[nx][ny][nz] = day[cur[0]][cur[1]][cur[2]] + 1;
            }
        }

        int max = 0;

        for(int i = 0 ; i<M ; i++) {
            for(int j = 0 ; j<N ; j++) {
                for(int k = 0 ; k<H ; k++) {
                    if(day[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max , day[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }
}
