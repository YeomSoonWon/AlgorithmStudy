import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int [] arr = new int[9];
        
        for(int i = 0 ; i<9 ; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            sum += num;
        }
        
        for(int i = 0 ; i<8 ; i++) {
            for(int j = i+1 ; j<9 ; j++) {
                int sum1 = arr[i] + arr[j];
                if((sum - sum1) == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
            if(arr[i]==0) {
                break;
            }
        }

        Arrays.sort(arr);

        for(int i = 2 ; i<9 ; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
        sc.close();
    }
}
