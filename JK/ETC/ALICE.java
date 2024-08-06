import java.util.Scanner;
import java.util.Stack;

public class ALICE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int cnt = 0;

        Stack<Integer> stk = new Stack<>();
        Stack<Character> jk = new Stack<>();

        for(int i = 0 ; i<str.length()-1 ; i++) {
            if(str.charAt(i) == '(') {
            }
            if(str.charAt(i+1) == '(') {
                stk.push(str.charAt(i) - '0');
            }
            else {
                jk.push(str.charAt(i));
            }
        }

        jk.push(str.charAt(str.length()-1));

        while(!jk.isEmpty()) {
            if(jk.peek() == ')') {
                jk.pop();
            }
            else if(jk.peek() == '(' && !stk.isEmpty()) {
                jk.pop();
                cnt *= stk.pop();
            }
            else if(!jk.contains('(')) {
                cnt++;
                jk.pop();
            }

            else {
                cnt++;
                jk.pop();
            }
        }
        
        System.out.println(cnt);

        sc.close();

    }

}
