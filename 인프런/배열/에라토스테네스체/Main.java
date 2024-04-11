package 인프런.배열.에라토스테네스체;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // 입력 값 까지의 소수의 개수를 출력하는 프로그램
    public int solution(int N) {
        int answer = 0;

        // 초기화
        boolean[] primeList = new boolean[N + 1];
        Arrays.fill(primeList, true);
        primeList[0] = false; // 숫자 계산을 쉽게하기 위해서 1부터 시작하도록 하기위한 공간을 false 처리
        primeList[1] = false;

        // 답은 맞았지만, 시간 초과
        for (int i = 2; i < N / 2; i++) {
            for (int j = i; j <= N; j++) {
                if (i != j && j % i == 0) {
                    primeList[j] = false;
                }
            }
        }

        for (boolean v : primeList) {
            if (v) answer++;
        }
        // 소수란? 자신 외에 나누어지는 수가 없는 수
        return answer;
    }

    public int solution3(int N) {
        int answer = 0;

        // 초기화
        boolean[] primeList = new boolean[N + 1];
        Arrays.fill(primeList, true);
        primeList[0] = false; // 숫자 계산을 쉽게하기 위해서 1부터 시작하도록 하기위한 공간을 false 처리
        primeList[1] = false;
        
        // 시간 초과를 줄이기 위한 노력
        // 1. 계산식을 더 간결하게 바꿔보기
        for (int i = 2; i < N; i++) { // 수를 끝까지 세야하기 때문에 N까지 확인하는 것이다.
            if(primeList[i]) answer++; // N까지 봐야 answer++를 전부 가능
            // 만약 그냥 배열만 만든다면 i는 N/2까지만 확인하면 된다.
            for (int j = i; j <= N; j = j + i) {
                primeList[j] = false;
            }
        }

        // 소수란? 자신 외에 나누어지는 수가 없는 수
        return answer;
    }

    public int solution2(int N) {
        int answer = 0;
        int[] ch = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= N; j = j + i) ch[j] = 1;
            }
        }
        // 소수란? 자신 외에 나누어지는 수가 없는 수
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        System.out.println(T.solution3(in.nextInt()));
    }
}
