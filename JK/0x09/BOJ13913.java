import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ13913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dist = new int[100001];
        int[] route = new int[100001];

        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.close();

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }
        que.add(N);
        stk.add(K);
        dist[N] = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();
            int nx;
            for (int dir = 0; dir < 3; dir++) {
                if (dir == 0) {
                    nx = cur + 1;
                } else if (dir == 1) {
                    nx = cur - 1;
                } else {
                    nx = cur * 2;
                }

                if (nx < 0 || nx > 100000 || dist[nx] != 0) {
                    continue;
                }
                que.add(nx);
                dist[nx] = dist[cur] + 1;
                route[nx] = cur;
            }
            if (dist[K] != 0) {
                break;
            }
        }
        System.out.println(dist[K] - 1);

        int index = K;

        while (index != N) {
            stk.add(route[index]);
            index = route[index];
        }

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }

    }
}
