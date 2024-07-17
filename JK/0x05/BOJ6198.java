import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> building = new Stack<>();

        //정답의 최대값(80001*40000)이 int의 범위를 넘어가 long으로 표현
        long result = 0;
        
        for(int i = 0 ; i<N ; i++) {
            int height = sc.nextInt();

            while(true) {
                //현재 입력받은 건물의 높이보다 작은 건물이 없다면 break
                if(building.isEmpty()) {
                    break;
                }
                else {

                    //N번째 건물의 옥상을 바라볼 수 있는 건물들의 개수를 구하기 위해 다음과 같이 반복
                    if(building.peek() <= height) {
                        building.pop();
                    }
                    else {
                        break;
                    }
                }
            }

            //각 건물을 볼 수 있는 건물의 개수를 더하는 방식
            result += building.size();

            //모든 시행이 끝나고 마지막으로 더해줘야 size에서 1을 빼지 않아도 됨
            building.add(height);
        }

        System.out.println(result);
        sc.close();
    }
}
