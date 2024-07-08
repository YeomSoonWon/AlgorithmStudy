import java.util.Scanner;

public class BOJ10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] arr = new int[201];

        for(int i = 0 ; i<N ; i++) {
            arr[sc.nextInt() + 100]++;
        }
        int V = sc.nextInt();

        System.out.println(arr[V + 100]);

        sc.close();
    }
}
