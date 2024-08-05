import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1차원 배열의 BFS
        //둘의 차이가 100000이기 때문에 최대 범위를 1000001로 지정
        int[] dist = new int[100002];
        Queue<Integer> que = new LinkedList<>();

        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        //모든 거리의 값들을 -1로 지정해서 방문 여부 설정
        for (int i = 0; i < 100002; i++) {
            dist[i] = -1;
        }

        //처음 출발하는 곳은 미리 설정
        dist[N] = 0;
        que.add(N);

        //이후 기존 BFS방식과 비슷
        while (true) {
            int cur = que.poll();
            int next;
            //기존에 사용하던 상하좌우가 아닌 +1, -1, X2의 연산을 해주어야 하므로 다음과 같은 반복문 사용
            for (int dir = 0; dir < 3; dir++) {
                if (dir == 0) {
                    next = cur + 1;
                } else if (dir == 1) {
                    next = cur - 1;
                } else {
                    next = cur * 2;
                }
                //만약 음수로 가거나 100000을 넘어갔다면 비효율적인 움직임이 예상되므로 생략
                if (next < 0 || next > 100000) {
                    continue;
                }

                //만약 방문했더라면 생략
                if (dist[next] != -1) {
                    continue;
                }

                dist[next] = dist[cur] + 1;
                que.add(next);

            }
            //반복하다 수빈이가 동생을 잡았다면 반복문 종료
            if (dist[M] != -1) {
                break;
            }
        }
        System.out.println(dist[M]);
        sc.close();
    }
}
