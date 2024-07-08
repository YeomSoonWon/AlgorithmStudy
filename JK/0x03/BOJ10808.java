import java.util.Scanner;

public class BOJ10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();
        int [] arr = new int[26];

        for(int i = 0 ; i<str.length() ; i++) {
            char at = str.charAt(i);
            arr[at - 'a']++;
        }

        for(int i = 0 ; i<26 ; i++) {
            sb.append(arr[i]).append(" ");
        }
        
        System.out.println(sb);

        sc.close();
    }
}
