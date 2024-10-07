import java.util.Arrays;
import java.util.Scanner;

public class BOJ2751 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();

    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    for (int k : arr) {
      sb.append(k).append("\n");
    }
    System.out.println(sb);

    sc.close();
  }
}
