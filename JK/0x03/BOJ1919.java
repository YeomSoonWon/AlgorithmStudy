import java.util.Scanner;

public class BOJ1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        //알파벳 별로 갯수를 세기 위해 배열 생성
        int [] arr = new int[26];
        int cnt = 0;

        //한 글자씩 
        for(int i = 0 ; i<str1.length() ; i++) {
            char ch1 = str1.charAt(i);
            arr[ch1 - 'a']++;
        }

        for(int j = 0 ; j<str2.length() ; j++) {
            char ch2 = str2.charAt(j);
            if(arr[ch2-'a'] == 0) {
                cnt++;
            }
            else if(arr[ch2-'a'] != 0) {
                arr[ch2 - 'a']--;
            }
        }

        for(int i = 0 ; i<26 ; i++) {
            cnt += arr[i];
        }

        System.out.println(cnt);

        sc.close();
    }
}