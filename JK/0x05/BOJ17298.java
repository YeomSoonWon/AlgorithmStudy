import java.util.Scanner;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        //값들을 비교해야하는데 Stack으로 비교하면 순서가 망가져서 배열을 생각
        int [] arr = new int[N];
        Stack<Integer> stk = new Stack<>();

        for(int i = 0 ; i<N ; i++) {
            //각각의 배열에 입력받은 값 등록
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i<N ; i++) {
            
            while(true) {

                //Stack이 비어있다면 break -> 비교 대상이 없으므로
                if(stk.isEmpty()) {
                    break;
                }

                //만약 Stack에 저장된 index보다 최근에 입력받은 수가 더 작다면 아무런 시행을 하지 않음
                else if(arr[stk.peek()] >= arr[i]){
                    break;
                }

                //그렇지 않다면 Stack에서 제거하고 오큰수를 각각의 index에 저장
                else {
                    arr[stk.pop()] = arr[i];
                }
            }

            //Stack에는 index를 저장
            stk.add(i);

        }

        while(!stk.isEmpty()) {
            //현재까지 Stack에 남아있다면 그 index에 해당하는 오큰수는 존재하지 않기 때문에 각각 -1로 변경
            arr[stk.pop()] = -1;
        }

        for(int k : arr) {
            //System.out.print() 를 사용하니 시간 초과가 나서 StringBuilder 사용
            sb.append(k).append(" ");
        }
        System.out.println(sb);
        sc.close();
    }
}
