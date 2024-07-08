import java.util.Scanner;

public class BOJ10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); //입력받는 숫자의 개수
        int X = sc.nextInt(); //조건이 되는 값

        for(int i = 0 ; i<N ; i++) {
            int num = sc.nextInt();
            //X보다 작으면 StringBuilder에 추가
            if(num < X) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
