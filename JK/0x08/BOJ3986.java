import java.util.Scanner;
import java.util.Stack;

public class BOJ3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //좋은 단어를 세기 위해 cnt 설정
        int cnt = 0;
        int N = sc.nextInt();
        Stack<Character> stk;

        for (int i = 0; i < N; i++) {
            //한 번 시행할때마다 Stack 초기화
            stk = new Stack<>();

            String str = sc.next();

            //입력받은 String의 길이만큼 반복
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                //만약 j번째 문자가 A라면
                if (ch == 'A') {
                    //Stack이 비어있다면 A 넣기(만약 if문의 순서를 바꾸면 stk.pop()이 Stack이 비어있을때 오류가 발생)
                    if(stk.isEmpty()) {
                        stk.add(ch);
                    }
                
                    //최근에 넣은 값이 A라면 쌍 빼주기
                    else if(stk.peek() == 'A') {
                        stk.pop();
                    }

                    //이 외의 경우엔 A 넣기
                    else {
                        stk.add(ch);
                    }
                }
                
                //만약 j번째 문자가 B라면
                if (ch == 'B') {
                    //Stack이 비어있다면 B 넣기
                    if(stk.isEmpty()) {
                        stk.add(ch);
                    }

                    //최근에 넣은 문자가 B라면 쌍 빼주기
                    else if(stk.peek() == 'B') {
                        stk.pop();
                    }
                    //이 외의 경우엔 B 넣기
                    else {
                        stk.add(ch);
                    }
                }

            }

            //정상적으로 작동하며 모든 쌍이 빠졌다면 cnt를 1 증가 시키기
            if (stk.isEmpty()) {
                cnt++;
            }

        }
        System.out.println(cnt);

        sc.close();
    }
}
