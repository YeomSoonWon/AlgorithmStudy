import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
public class BOJ1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>();

        String [] arr = br.readLine().split("");

        for(String s : arr) {
            list.add(s);
        }

        int N = Integer.parseInt(br.readLine());

        ListIterator<String> iter = list.listIterator();

        while (iter.hasNext()) {
            iter.next();
        }

        for (int j = 0; j < N ; j++) {
            String [] order = br.readLine().split(" ");

            switch (order[0]) {
                case "L":
                    if (iter.hasPrevious()) {
                            iter.previous();
                    }
                    break;
                case "D":
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case "B":
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    iter.add(order[1]);
            }
        }

        System.out.println(String.join("", list));

        br.close();
    }
}
