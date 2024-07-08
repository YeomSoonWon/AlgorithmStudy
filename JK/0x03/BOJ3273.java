import java.util.Scanner;

public class BOJ3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        int [] arr = new int[N];
        boolean [] sum = new boolean[2000001];
        int cnt = 0;
        
        for(int i = 0 ; i<N ; i++) {
            arr[i] = sc.nextInt();
        }

        int X = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            if(X-arr[i]>0 && sum[X-arr[i]]) {
                cnt++;
            }
            sum[arr[i]] = true;
        }

        System.out.println(cnt);

        sc.close();
    }
}
