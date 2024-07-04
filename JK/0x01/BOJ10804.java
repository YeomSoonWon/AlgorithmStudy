import java.util.Scanner;

public class BOJ10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] arr = new int[20];

        for(int i = 0 ; i<20 ; i++) {
            arr[i] = i+1;
        }

        for(int i = 0 ; i<10 ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for(int j = start-1 ; j<end-1 ; j++) {
                for(int k = j+1 ; k<end ; k++) {
                    int tmp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = tmp;
                }
            }
        }

        for(int i = 0 ; i<20 ; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
