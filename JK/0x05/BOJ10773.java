import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stk = new Stack<>();
        //0일때는 stack에서 제거, 그 외에는 추가하는 실행
        for(int i = 0 ; i<N ; i++) {
            int num = sc.nextInt();

            switch (num) {
                case 0:
                    stk.pop();
                    break;
            
                default:
                    stk.add(num);
                    break;
            }
        }
        //stack에 있는 모든 원소를 더하기
        int all = 0;
        for(int k : stk) {
            all += k;
        }

        System.out.println(all);

        sc.close();
    }
}
