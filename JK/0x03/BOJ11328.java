import java.util.Arrays;
import java.util.Scanner;

public class BOJ11328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i = 0 ; i<N ; i++) {
            int [] arr1 = new int[26];
            int [] arr2 = new int[26];
            String str = sc.next();
            
            for(int j = 0 ; j<str.length() ; j++) {
                char c = str.charAt(j);
                arr1[c-'a']++;
            }

            String comp = sc.next();

            for(int k = 0 ; k<comp.length() ; k++) {
                char ch = comp.charAt(k);
                arr2[ch - 'a']++;
            }

            if(Arrays.equals(arr1, arr2)) {
                sb.append("Possible").append('\n');
            }
            else {
                sb.append("Impossible").append('\n');
            }

        }
        System.out.println(sb);

        sc.close();
    }
}
