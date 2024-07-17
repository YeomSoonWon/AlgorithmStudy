import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    public static void main(String[] args) throws IOException{
        //Scanner로 하니까 메모리 초과가 나서 BufferedReader로 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //탑의 높이 비교를 위한 stk , 위치를 저장하기 위한 index Stack 두 개를 생성
        Stack<Integer> stk = new Stack<>();
        Stack<Integer> index = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        //한 줄로 입력된 정수를 모두 StringTokenizer로 저장
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<N ; i++) {
            //최근에 입력된 탑의 값을 저장
            int top = Integer.parseInt(st.nextToken());

            //만약 stk가 비어있다면 0을 출력(초기에 해당)
            if(stk.isEmpty()) {
                System.out.print(0 + " ");
            }

            else {
                //원하는 만큼 실행하기 위해 무한 루프로 설정
                while(true) {
                    //stk의 맨 위의 값을 저장
                    int data = stk.peek();

                    //만약 stk의 맨 위의 값이 입력받은 값보다 크다면 stk의 맨 위의 값이 현재 가장 높은 탑이므로 그 탑의 index를 출력
                    if(data > top) {
                        System.out.print(index.peek() + " ");
                        break;
                    }

                    //그렇지 않다면 입력받은 값보다 큰 값을 찾아내기 위해 계속해서 stk와 index 스택의 값을 제거
                    else {
                        stk.pop();
                        index.pop();
                    }

                    //계속해서 반복하다 top의 값이 제일 높아 stk가 비어버리게 되면 도달하는 곳이 없으므로 0 출력 후 무한 루프 종료
                    if(stk.isEmpty()) {
                        System.out.print(0 + " ");
                        break;
                    }
                }   
            }

            //마지막으로 입력받은 값과 그에 해당하는 index를 스택에 저장 후 다시 반복
            stk.add(top);
            index.add(i+1);
        }
        
    }
}
