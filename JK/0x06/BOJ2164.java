import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //처음에 Deque로 시도했으나 굳이 그럴 필요 없어서 Queue로 고쳐서 해봤습니다
        Queue<Integer> que = new LinkedList<>();

        int N = sc.nextInt();

        //1부터N까지 Queue에 저장
        for(int i = 0 ; i<N ; i++) {
            que.add(i+1);
        }

        //Queue에 들어있는 숫자가 1개가 될때까지 반복
        while(que.size() != 1) {
            que.poll();
            que.add(que.poll());
        }

        //마지막에 남아있는 숫자 출력
        System.out.println(que.poll());
        sc.close();
    }
}
