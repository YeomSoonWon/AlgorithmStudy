import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();

        int N = sc.nextInt();
        //1부터N까지 stack에 추가하기 위해 put을 1로 시작
        int put = 1;
        //후에 NO와 일반 출력과 구분하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<N ; i++) {
            int num = sc.nextInt();
            //put이 N까지만 들어갈 수 있게 while의 조건을 다음과 같이 나타냄
            while(put <= N+1) {
                //stack이 비어있다면 peek가 오류가 나므로 put을 넣어주고 그 후 put을 증가시키기
                if(stk.isEmpty()) {
                    stk.push(put);
                    put++;
                    sb.append("+").append("\n");
                }
                //만약 입력받은 값과 stack의 맨 위에 있는 원소가 동일하다면 pop
                else if(num == stk.peek()) {
                    stk.pop();
                    sb.append("-").append('\n');
                    break;
                }
                //그 이외에는 push
                else {
                    stk.push(put);
                    put++;
                    sb.append("+").append("\n");
                }
            }
        }

        //정상적으로 실행이 완료되어 stack이 전부 비워졌다면 while문에서 합친 것을, 비어있지 않다면 NO를 출력
        if(stk.size() == 0) {
            System.out.println(sb);
        }
        else {
            System.out.println("NO");
        }
        sc.close();     
    }
}
