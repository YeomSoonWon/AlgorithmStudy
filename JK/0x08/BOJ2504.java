import java.util.Scanner;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Character> stk = new Stack<>();

        //Stack에 오류가 있는지 확인하기 위한 chk
        boolean chk = true;
        //총 합을 나타내는 sum과 부분적인 합을 나타내기 위한 add로 구성
        int sum = 0;
        int add = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //우선 '('를 입력받으면 기존의 add값에 2배를 한다(Ex.(())인 경우 4인데 이는 add*2*2로 나타난다)
            if (ch == '(') {
                stk.add(ch);
                add *= 2;
            }

            //'['를 입력받으면 기존의 add값에 3배를 한다.
            else if (ch == '[') {
                stk.add(ch);
                add *= 3;
            }

            //')'를 입력받으면
            else if (ch == ')') {
                //Stack이 비어있거나 '('이 아닌 경우 Stack에 오류가 났음을 저장하고 break를 한다.
                if (stk.isEmpty() || stk.peek() != '(') {
                    chk = false;
                    break;
                }
                
                //만약(()[])일때 계산은 add*2*2 + add*2*3과 같이 나타난다. 따라서 닫는 기호인 ')'과 ']' 이 바로 앞에 문자열과 쌍으로 나타나면 그때 sum에 더해주고 add를 나눠주기
                //add = 1 -> add = 2 -> add = 4 -> sum = 4 , add = 2 -> add = 6 -> sum = 10 , add = 2 -> add = 1
                else if (str.charAt(i-1) == '(') {
                    sum += add;
                }

                stk.pop();
                add /= 2;
            }

            else if (ch == ']') {
                if (stk.isEmpty() || stk.peek() != '[') {
                    chk = false;
                    break;
                }

                else if(str.charAt(i-1) == '[') {
                    sum += add;
                }
                stk.pop();
                add /= 3;
            }
        }
        
        //만약 Stack에서 오류가 있었다면 0을 아니면 sum을 출력
        if(chk && stk.isEmpty()) {
            System.out.println(sum);
        }
        else {
            System.out.println(0);
        }

        sc.close();
    }
}
