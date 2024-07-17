import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        //오른쪽으로 회전시키는 dq1과 왼쪽으로 회전시키는 dq2로 구성
        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();

        //오른쪽과 왼쪽으로 이동시키는 횟수를 세기 위한 count1 , count2
        int count1 = 0;
        int count2 = 0;

        int sum = 0;

        for(int i = 0 ; i<N ; i++) {
            //각각의 Deque에 1~N까지 입력
            dq1.addLast(i+1);
            dq2.addLast(i+1);
        }

        for(int i = 0 ; i<M ; i++) {

            //count1 과 count2는 시행마다 초기화
            count1 = 0;
            count2 = 0;
            int num = sc.nextInt();

            while(dq1.contains(num)) {
                //만약 맨 앞에 수가 원하는 수와 일치하다면 제거(횟수는 증가X)
                if(dq1.peekFirst() == num) {
                    dq1.removeFirst();
                }
                else {
                    //그렇지 않다면 횟수를 증가시키고 오른쪽으로 한 칸씩 이동
                    dq1.addFirst(dq1.removeLast());
                    count1++;
                }
            }

            while(dq2.contains(num)) {
                //만약 맨 앞에 수가 원하는 수와 일치하다면 제거(횟수는 증가X)
                if(dq2.peekFirst() == num) {
                    dq2.removeFirst();
                }
                else {
                    //그렇지 않다면 횟수를 증가시키고 왼쪽으로 한 칸씩 이동
                    dq2.addLast(dq2.removeFirst());
                    count2++;
                }
            }

            //count1 과 count2 중 적은 횟수로 이동한 것을 sum에 합산
            if(count1 > count2) {
                sum += count2;
            }
            else {
                sum += count1;
            }
        }
        System.out.println(sum);

        sc.close();
    }
}
