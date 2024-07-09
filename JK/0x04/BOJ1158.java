import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i = 0 ; i<N ; i++) {
            list.add(i+1);
        }
        sb.append("<");
        while(!list.isEmpty()){

            for(int i = 0 ; i<K ; i++) {
                if(i==K-1) {
                    if(list.size() == 1) {
                        sb.append(list.remove());
                    }
                    else {
                        sb.append(list.remove()).append(", ");
                    }
                }
                else {
                    list.add(list.remove());
                }
            }
        }

        sb.append(">");

        System.out.println(sb);

        sc.close();
    }
}
