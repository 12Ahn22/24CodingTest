package 인프런.배열.가위바위보;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // 입력값 N - 게임 횟수
    // 입력값 A - A가 낸 정보
    // 입력값 B - B가 낸 정보
    // 출력값 - 게임별 이긴 사람, 비긴 경우 D 출력
    public String solution(int a, int b) {
        // 1:가위, 2:바위, 3:보
        String answer = "D"; // 비긴 경우 값으로 초기화
        // a를 기준으로 가위바위보
        switch (a){
            case 1: // 가위
                if(b == 1) answer = "D";
                if(b == 2) answer = "B";
                if(b == 3) answer = "A";
                break;
            case 2: // 바위
                if(b == 1) answer = "A";
                if(b == 2) answer = "D";
                if(b == 3) answer = "B";
                break;
            case 3: // 보
                if(b == 1) answer = "B";
                if(b == 2) answer = "A";
                if(b == 3 ) answer = "D";
                break;
        }
        return answer;
    }

    public String solution2(int a, int b) {
        // 1:가위, 2:바위, 3:보
        String answer = "D"; // 비긴 경우 값으로 초기화
        // a를 기준으로 가위바위보
        if(a == b) answer = "D";
        else if(a == 1 && b == 3) answer = "A";
        else if(a == 2 && b == 1) answer = "A";
        else if(a == 3 && b == 2) answer = "B";
        else answer = "B";
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int N = Integer.parseInt(in.nextLine());
        int[] A = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < N; i++){
            System.out.println(T.solution(A[i],B[i]));
        }
    }
}
