import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7562 {
    public static boolean [][]board;
    public static int [][]dist;
    public static int []dx = {-1,-1,1,1,-2,-2,2,2};
    public static int []dy = {2,-2,2,-2,1,-1,1,-1};
    public static int L;
    public static int endX;
    public static int endY;
    public static Queue<int[]> que;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            L = sc.nextInt();
            
            board = new boolean[L][L];
            dist = new int[L][L];
            que = new LinkedList<>();

            int x = sc.nextInt();
            int y = sc.nextInt();

            endX = sc.nextInt();
            endY = sc.nextInt();

            board[x][y] = true;
            que.add(new int[]{x,y});
            
            bfs(x,y);
        }
        sc.close();
    }

    private static void bfs(int x, int y) {
        if(x==endX && y==endY) {
            System.out.println(0);
            return;
        }
        while(true) {
            int []cur = que.poll();

            for(int dir = 0 ; dir<8 ; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(nx<0 || nx>=L || ny<0 || ny>=L) {
                    continue;
                }
                if(dist[nx][ny] != 0 || board[nx][ny]) {
                    continue;
                }

                que.add(new int[]{nx,ny});
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

                if(nx == endX && ny == endY) {
                    System.out.println(dist[nx][ny]);
                    return;
                }
            }
        }
    }
}
