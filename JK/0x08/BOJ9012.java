import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Stack<Character> stk;
        for(int i = 0 ; i<N ; i++) {
            //한 번 시행할때마다 Stack 초기화
            stk = new Stack<>();

            String str = sc.next();

            //String의 문자 길이 만큼 반복
            for(int j = 0 ; j<str.length() ; j++) {
                char ch = str.charAt(j);

                //j번째 문자가 '('라면 Stack에 추가
                if(ch == '(') {
                    stk.add(ch);
                }

                //j번째 문자가 ')'라면
                else if(ch == ')') {
                    //Stack이 비어있거나 최근 받은 문자열이 '('이 아니면 오류를 출력하기 위해 X를 넣고 break
                    if(stk.isEmpty() || stk.peek() != '(') {
                        stk.add('X');
                        break;
                    }
                    //이 외의 경우엔 쌍 빼주기
                    else {
                        stk.pop();
                    }
                }
            }

            //만약 Stack이 비어있으면 정상 그렇지 않으면 X가 들어가 있어서 오류를 출력하도록 한다
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
