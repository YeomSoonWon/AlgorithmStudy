import java.util.Arrays;
import java.util.Scanner;

public class BOJ1475 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //방 번호 입력
        int [] arr = new int[10]; //0~9까지 추가 될 배열

        //10으로 나눈 나머지들의 위치에 해당하는 배열에 1씩 더하기
        while(N>0) {
            int num = N%10;

            //6과 9는 서로 같은 경우로 보기 위해 if 문으로 적은 곳에 1씩 더하기
            if(num == 6 || num == 9) {
                if(arr[6] > arr[9]) {
                    arr[9]++;
                }
                else {
                    arr[6]++;
                }
            }

            //나머지는 일반적으로 1씩 더하기
            else {
                arr[num]++;
            }

            //N에 N을 10으로 나눈 몫을 저장
            N /= 10;
        }

        //최대값을 찾기 위해 정렬하고 배열의 마지막에 있는 값을 출력
        Arrays.sort(arr);
        System.out.println(arr[9]);

        sc.close();
    }
}
