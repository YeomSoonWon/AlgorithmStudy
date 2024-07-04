import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int [] arr = new int[9];

        for(int i = 0 ; i<9 ; i++) {
            int put = sc.nextInt();
            hm.put(put, i+1);
            arr[i] = put;
        }

        sc.close();

        Arrays.sort(arr);
        System.out.println(arr[8]);
        System.out.println(hm.get(arr[8]));
    }
}
