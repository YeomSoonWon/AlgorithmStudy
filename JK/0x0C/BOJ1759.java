import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759 {
    static int L, C;
    static char[] arr;
    static char[] chk;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        arr = new char[C];
        chk = new char[C];
        vis = new boolean[C];

        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);
        func(0, 0);
        sc.close();
    }

    private static void func(int d, int start) {
        if (d == L) {
            int cntM = 0;
            int cntJ = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                char ch = chk[i];
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    cntM++;
                } else {
                    cntJ++;
                }
                sb.append(ch);
            }
            if (cntM >= 1 && cntJ >= 2) {
                System.out.println(sb.toString());
            }
        }

        for (int i = start; i < C; i++) {
            chk[d] = arr[i];
            func(d + 1, i + 1);
        }
    }
}
