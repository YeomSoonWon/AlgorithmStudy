import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static StringBuilder sb = new StringBuilder();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        int N = sc.nextInt();
        Deque<Integer> dq;

        for(int i = 0 ; i<N ; i++) {
            //반복문을 시행할때마다 Deque가 초기화 되도록 설정
            dq = new LinkedList<>();

            //각각 명령문과 숫자의 갯수와 안에 입력받을 수를 입력받기
            String order = sc.next();
            int num = sc.nextInt();
            String s = sc.next();

            //'[' 와 ']' 그리고 ','을 제외하고 숫자만 받기 위해 Token화
            st = new StringTokenizer(s , "[],");

            //Token화 된 값을 Deque에 넣기
            for(int j = 0 ; j<num ; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            //결과를 출력받기 위한 함수
            AC(order , dq);
        }

        System.out.println(sb);
    }

    private static void AC(String order, Deque<Integer> dq) {
        //뒤집힌건지 아닌지 판단하기 위한 boolean 값 설정
        boolean reverse = true;

        //명령문 알파벳 갯수만큼 반복
        for(int i = 0 ; i<order.length() ; i++) {

            //만약 R을 입력받았다면 뒤집기
            if(order.charAt(i) == 'R') {
                reverse = !reverse;
                //break로 걸어버리니까 반복문이 마무리가 되어서 continue를 사용
                continue;
            }

            //만약 뒤집히지 않았다면
            if(reverse) {
                //만약 Deque가 비어있어서 더 이상 수를 제거할 수 없다면 error를 추가하고 return
                if(dq.isEmpty()) {
                    sb.append("error").append('\n');
                    return;
                }
                //그렇지 않다면 처음부터 하나씩 꺼내기
                else {
                    dq.removeFirst();
                }
            }

            //만약 뒤집혔다면
            if(!reverse) {
                //만약 Deque가 비어있어서 더 이상 수를 제거할 수 없다면 error를 추가하고 return
                if(dq.isEmpty()) {
                    sb.append("error").append('\n');
                    return;
                }
                //그렇지 않다면 마지막부터 하나씩 꺼내기
                else {
                    dq.removeLast();
                }
            }
        }

        //error가 뜨지 않았더라면 출력의 첫 시작인 '['를 넣기
        sb.append('[');

        //이때 AC의 명령문이 정상적으로 마무리 되고 Deque의 Size가 0이라면 출력이 [null]로 뜨기 때문에 이러한 조건문으로 해결
        if(dq.size() > 0) {
            //만약 뒤집히지 않았더라면 처음부터 Deque에 있는 모든 원소를 꺼내기
            if(reverse) {
                sb.append(dq.pollFirst());
    
                while(!dq.isEmpty()) {
                    sb.append(',').append(dq.pollFirst());
                }
            }

            //그렇지 않다면 마지막부터 Deque에 있는 모든 원소를 꺼내기
            else {
                sb.append(dq.pollLast());
    
                while(!dq.isEmpty()) {
                    sb.append(',').append(dq.pollLast());
                }
            }
        }

        
        //출력의 마지막 부분인 ']' 입력
        sb.append(']').append('\n');

    }
    
}
