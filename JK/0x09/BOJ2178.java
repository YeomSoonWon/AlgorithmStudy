import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력받은 값을 기준으로 상,하,좌,우를 판단하기 위해 다음 배열 설정
        int [] dx = new int[]{-1 , 0 , 1 , 0};
        int [] dy = new int[]{0 , -1 , 0 , 1};
        Queue<int[]> que = new LinkedList<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        //미로판을 입력받기 위한 board 와 거리를 저장하기 위한 dist배열
        char [][] board = new char[n][m];
        int [][] dist = new int[n][m];

        //dist의 값들은 -1로 초기화 시켜서 방문했는지 안했는지를 판단
        for(int i = 0 ; i<n ; i++) {
            String str = sc.next();
            for(int j = 0 ; j<str.length() ; j++) {
                board[i][j] = str.charAt(j);
                dist[i][j] = -1;
            }
        }

        //(0,0) 의 위치는 항상 출발점이므로 미리 입력받아주기
        que.add(new int[]{0,0});
        dist[0][0] = 1;

        while(!que.isEmpty()) {
            int [] cur = que.poll();

            for(int dir = 0 ; dir<4 ; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                //(nx,ny)가 범위를 벗어나는 것을 방지
                if(nx<0 || nx>=n || ny<0 || ny>=m) {
                    continue;
                }

                //만약 막다른 길이거나 방문했던 길이라면 건너뛰기
                if(board[nx][ny] == '0' || dist[nx][ny] != -1) {
                    continue;
                }

                que.add(new int[]{nx,ny});
                //거리는 전에 참조했던 곳에서 +1을 해준다
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
            }
        }
        //마지막에 도달한 곳의 거리를 출력
        System.out.println(dist[n-1][m-1]);

        sc.close();
    }
}
