import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10845 {
    //전역 변수로 사용하지 않아도 상관X
    static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> qu = new LinkedList<>();
        //System.out.println으로 출력을 해보니 시간초과가 나서 StringBuilder로 출력
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt();

        //N번 시행
        for(int i = 0 ; i<N ; i++) {
            String order = sc.next();

            //switch case 문으로 시간 절약
            switch (order) {
                case "push" :
                //가장 최근에 add된 숫자가 맨 뒤에 있으므로 num에 back을 저장
                    num = sc.nextInt();
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
                //back은 queue에서는 알 수 없으므로 미리 저장된 num을 불러오기
                else {
                    sb.append(num).append('\n');
                    break;
                }
                    
            }
        }
        System.out.println(sb);
        sc.close();
    }    
}
