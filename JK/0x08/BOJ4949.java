import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk;
        
        // "." 이 찍히기 전까지 무한 반복
        while(true) {
            stk = new Stack<>();
            String str = sc.nextLine();

            //만약 입력받은 값이 "." 이라면 반복문 종료
            if(str.equals(".")) {
                break;
            }

            //입력받은 문자열의 길이만큼 반복
            for(int i = 0 ; i<str.length() ; i++) {
                char ch = str.charAt(i);

                //만약 i번째 문자가 '(' 라면 Stack에 0을 받기(사실 Stack을 Charater의 값을 넣도록 하면 그냥 ch로 넣으면 된다)
                if(ch == '(') {
                    stk.add(0);
                }

                //'[' 라면 1을 받기
                else if(ch == '[') {
                    stk.add(1);
                }

                //')'와 ']' 일때는 경우를 좀 더 나누기
                else if(ch == ')') {
                    //Stack이 비어있거나 맨 위가 '(' 이 아니라면 -1을 대입하고 break(후에 Stack이 비어있는 것의 참 거짓으로 오류를 판단)
                    if(stk.isEmpty() || stk.peek() != 0) {
                        stk.add(-1);
                        break;
                    }

                    //정상적이라면 쌍을 빼주기
                    else {
                        stk.pop();
                    }
                }
                
                else if(ch == ']') {
                    //Stack이 비어있거나 맨 위가 '['이 아니라면 -1을 대입하고 break
                    if(stk.isEmpty() || stk.peek() != 1) {
                        stk.add(-1);
                        break;
                    }

                    //정상적이라면 쌍을 빼주기
                    else {
                        stk.pop();
                    }
                }
            }


            //만약 Stack이 비어있다면 정상 그렇지 않다면 오류이기 때문에 다음과 같이 출력
            if(stk.isEmpty()) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }

        }
        sc.close();
    }
}
