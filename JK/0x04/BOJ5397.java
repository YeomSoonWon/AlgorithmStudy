import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] key = br.readLine().split("");
            LinkedList<String> list = new LinkedList<>();
            ListIterator<String> iter = list.listIterator();

            for (int j = 0; j < key.length; j++) {
                String ch = key[j];
                switch (ch) {
                    case "<":
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case ">":
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case "-":
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(ch);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(String s : list) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}
