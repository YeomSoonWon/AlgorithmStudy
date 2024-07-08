import java.util.Scanner;

public class BOJ13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int [] male = new int[7];
        int [] female = new int[7];
        int cnt = 0;

        for(int i = 0 ; i<N ; i++) {
            int sex = sc.nextInt();
            int grade = sc.nextInt();

            if(sex == 0) {
                female[grade]++;
            }
            else {
                male[grade]++;
            }
        }
        
        for(int i = 1 ; i<7 ; i++) {
            if(male[i]%K == 0) {
                cnt = cnt + (male[i]/K);
            }
            else {
                cnt = cnt + (male[i]/K) + 1;
            }

            if(female[i]%K == 0) {
                cnt = cnt + (female[i]/K);
            }
            else {
                cnt = cnt + (female[i]/K) + 1;
            }
        }
        System.out.println(cnt);

        sc.close();
    }
}
