import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258 {
    public static void main(String[] args) throws IOException{
        //Scanner + StringBuilder로 시도해봤으나 시간 초과가 나서 BufferedReader로 교체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        //Back을 저장하기 위한 num
        int num = 0;

        //입력받은 줄을 띄어쓰기 기준으로 나누기 위해 StringTokenizer 사용
        st = new StringTokenizer(br.readLine());
        //입력받은 값들은 String이므로 Integer로 바꿔주기
        int N = Integer.parseInt(st.nextToken());


        //이후는 BOJ10845와 동일
        for(int i = 0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "push" :
                    num = Integer.parseInt(st.nextToken());
                    qu.add(num);
                    break;

                case "pop" :
                    if(qu.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    else {
                        sb.append(qu.poll()).append('\n');
                        break;
                    }

                case "size" :
                    sb.append(qu.size()).append('\n');
                    break;

                case "empty" :
                    if(qu.isEmpty()) {
                        sb.append(1).append('\n');
                        break;
                    }
                    else {
                        sb.append(0).append('\n');
                        break;
                    }

                case "front" :
                    if(qu.isEmpty()) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    else {
                        sb.append(qu.peek()).append('\n');
                        break;
                    }

                case "back" :
                if(qu.isEmpty()) {
                    sb.append(-1).append('\n');
                    break;
                }
                else {
                    sb.append(num).append('\n');
                    break;
                }
                    
            }
        }
        System.out.println(sb);
        
    }
}
