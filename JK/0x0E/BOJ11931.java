import java.util.Arrays;
import java.util.Scanner;

public class BOJ11931 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int N = sc.nextInt();

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    for (int i = N - 1; i >= 0; i--) {
      sb.append(arr[i]).append("\n");
    }
    System.out.println(sb);
    sc.close();
  }
}
