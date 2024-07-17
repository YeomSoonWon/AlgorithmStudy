import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();
        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            String order = sc.next();

            switch (order) {
                case "push_front":
                    dq.addFirst(sc.nextInt());
                    break;
                
                case "push_back":
                    dq.addLast(sc.nextInt());
                    break;

                case "pop_front":
                    if(dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.removeFirst()).append('\n');
                    }
                    break;

                case "pop_back":
                    if(dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.removeLast()).append('\n');
                    }
                    break;

                case "size":
                    sb.append(dq.size()).append('\n');
                    break;

                case "empty":
                    if(dq.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    if(dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.peekFirst()).append('\n');
                    }
                    break;

                case "back":
                    if(dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.peekLast()).append('\n');
                    }
                    break;
            }
        }

        //System.out.println을 사용하면 시간초과 오류가 난다
        System.out.println(sb);
        sc.close();
    }    
}
