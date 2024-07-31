import java.util.Scanner;
import java.util.Stack;
public class BOJ10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        //레이져와 쇠 막대를 구분하기 위해 boolean값으로 체크
        boolean chk = true;
        //쇠 막대의 분리된 개수를 세기 위한 cnt
        int cnt = 0;

        Stack<Character> stk = new Stack<>();

        for(int i = 0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);

            //만약 '('이 추가되면 Stack에 넣고 chk를 true로 바꿔주기(레이져 포인트의 경우 ')'를 입력받는 순간 추가적으로 '('를 입력받지 않으면 나머지 ')'는 쇠막대이므로 이런 방식 선택)
            if(ch == '(') {
                chk = true;
                stk.add(ch);
            }

            //만약 ')'이 추가되면
            else {
                //바로 앞에 입력받은 값이 '('이면 쌍이 되므로 레이져 취급
                //따라서 Stack에서 제거한 후 '('의 갯수만큼 cnt에 추가(레이져로 자른 쇠막대의 앞 부분)
                if(chk) {
                    stk.pop();
                    cnt += stk.size();
                }

                //만약 '))' 이런 경우 쇠막대의 마지막이 나타나므로 cnt를 1 증가 시킨다(자르고 나머지는 1씩만 남으므로)
                //Stack에서 제거
                else {
                    stk.pop();
                    cnt++;
                }
                //마지막으로 chk는 false로 바꿔서 앞에서 입력받은 값이 ')'임을 나타낸다
                chk = false;
            }
        }
        System.out.println(cnt);

        sc.close();
    }
}
