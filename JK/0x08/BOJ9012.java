import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Stack<Character> stk;
        for(int i = 0 ; i<N ; i++) {
            stk = new Stack<>();

            String str = sc.next();

            for(int j = 0 ; j<str.length() ; j++) {
                char ch = str.charAt(j);

                if(ch == '(') {
                    stk.add(ch);
                }
                else if(ch == ')') {
                    if(stk.isEmpty() || stk.peek() != '(') {
                        stk.add('X');
                        break;
                    }
                    else {
                        stk.pop();
                    }
                }
            }
            if(stk.isEmpty()) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
