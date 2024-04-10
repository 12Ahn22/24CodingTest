package 인프런.배열.보이는학생;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int solution(int N, String input){
        // 맨 앞줄부터 선생님이 볼 수 있는 학생의 수
        // 앞자리 사람보다 키가 작다면 보이지않는다.
        int[] list = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        int currentStudent = 0;

        for(int i = 0; i < N; i++){
            if(list[i] > currentStudent) {
                answer++;
                currentStudent = list[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        System.out.println(T.solution(N, in.nextLine()));
    }
}
