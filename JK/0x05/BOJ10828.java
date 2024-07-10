import java.util.Scanner;
import java.util.Stack;

public class BOJ10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();

        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            //명령문 받기
            String order = sc.next();
            //switch case문을 이용해 명령문 실행
            switch (order) {
                case "push":
                    int num = sc.nextInt();
                    stk.push(num);
                    break;

                case "pop":
                    if(stk.size() == 0) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stk.pop());
                    }
                    break;

                case "size":
                    System.out.println(stk.size());
                    break;

                case "empty":
                    if(stk.isEmpty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                case "top": 
                    if(stk.size()==0) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(stk.peek());
                    }
            }
        }
        sc.close();
    }    
}
