import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int min = Integer.MAX_VALUE;

        boolean[] vis = new boolean[100001];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { N, 0 });

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            vis[cur[0]] = true;

            if (cur[0] == K) {
                min = Math.min(min, cur[1]);
            }

            if (cur[0] * 2 <= 100000 && !vis[cur[0] * 2]) {
                que.add(new int[] { cur[0] * 2, cur[1] });
            }
            if (cur[0] + 1 <= 100000 && !vis[cur[0] + 1]) {
                que.add(new int[] { cur[0] + 1, cur[1] + 1 });
            }
            if (cur[0] - 1 >= 0 && !vis[cur[0] - 1]) {
                que.add(new int[] { cur[0] - 1, cur[1] + 1 });
            }

        }
        System.out.println(min);
        sc.close();
    }
}