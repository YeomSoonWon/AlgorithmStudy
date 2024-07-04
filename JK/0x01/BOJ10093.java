import java.util.Scanner;

public class BOJ10093 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();


        if(a==b) {
            System.out.println(0);
        }
        if(b>a) {
            System.out.println(b-a-1);
            for(long i = (a+1) ; i<b ; i++) {
                sb.append(i).append(" ");
            }
        }
        if(b<a) {
            System.out.println(a-b-1);
            for(long i = (b+1) ; i<a ; i++) {
                System.out.print(i+" ");
            }
        }
        
        System.out.println(sb);

        sc.close();
    }
}
