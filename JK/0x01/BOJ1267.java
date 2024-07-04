import java.util.Scanner;

public class BOJ1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int sumM = 0;
        int sumY = 0;

        for(int i = 0 ; i<N ; i++) {
            int time = sc.nextInt();

            sumY += ((time/30) + 1)*10;
            sumM += ((time/60) + 1)*15;
        }

        if(sumY>sumM) {
            System.out.println('M' + " " + sumM);
        }
        else if(sumY<sumM) {
            System.out.println('Y' + " " + sumY);
        }
        else if(sumM == sumY) {
            System.out.println('Y' + " " +'M' + " " + sumM);
        }
        
        sc.close();
    }
}
