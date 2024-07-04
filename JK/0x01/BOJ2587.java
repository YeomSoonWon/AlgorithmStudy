import java.util.Arrays;
import java.util.Scanner;

public class BOJ2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] arr = new int[5];
        int sum = 0;

        for(int i = 0 ; i<5 ; i++) {
            int num = sc.nextInt();
            sum += num;
            arr[i] = num;
        }
        
        Arrays.sort(arr);

        System.out.println(sum/arr.length);
        System.out.println(arr[(arr.length/2) + (arr.length%2) - 1]);
        
        sc.close();
    }
}
