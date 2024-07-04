import java.util.Scanner;

public class BOJ2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int D = A*B*C;

        int [] arr = new int[10];

        while(D>0) {
            arr[D%10]++;
            D /= 10;
        }

        for(int i = 0 ; i<10 ; i++) {
            System.out.println(arr[i]);
        }

        sc.close();
    }
}
