import java.util.Scanner;

public class BOJ9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int grade = sc.nextInt();
        
        sc.close();

        if(grade>89) {
            System.out.println("A");
        }
        else if(grade>79) {
            System.out.println("B");
        }
        else if(grade>69) {
            System.out.println("C");
        }
        else if(grade>59) {
            System.out.println("D");
        }
        else {
            System.out.println("F");
        }
    }
}