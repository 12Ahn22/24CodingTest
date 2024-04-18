package 인프런.슬라이드윈도우.연속부분수열;

import java.util.Scanner;

public class Main {

    // 연속하는 수열의 부분의 합이 특정 숫자 M이 되는 횟수를 구하시오.
    public int error(int N, int M, int[] input) {
        int answer = 0;
        // 일단 앞에서부터 하나씩 더한다
        // M과 같은 순간에 도달한다면 +1
        //  - 이후 맨 앞을 빼고, 맨 뒤를 더한다.
        //  - M과 같은지 확인 =>
        //      - M보다 작다면 빼지말고 맨 뒤를 더함
        //      - M보다 크다면 맨 뒤를 빼기
        int p1 = 0;
        int p2 = 1;
        int sum = input[p1];
        while (p2 < N && p1 < N) {
            // 특정 숫자 M과 합이 같다.
            if (sum == M) {
                answer++;
                // 다음 계산을 위해
                // p2와 p1 중 더 짧은 쪽을 사용하기
                if (p1 < p2) {
                    sum -= input[p1++];
                } else sum += input[p2++];
            } else if (sum < M) {
                // sum 값을 늘리기 위해서 맨 뒤를 더한다.
                sum += input[p2++];
            } else {
                // sum 값을 줄이기 위해서 맨 앞을 뺀다.
                sum -= input[p1++];
            }
        }
        return answer;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;

        // rt가 마지막까지 도달하면 끝난다.
        // 그래서 for문을 rt를 기준으로 돈다.
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt]; // rt위치의 값을 더한다.

            // 더한 값이 M보다 크다면,
            while (sum > m) {
                // 맨 앞을 빼야한다.
                sum -= arr[lt++];
            }
            // 만약 같다면, answer ++
            if (sum == m) answer++;
        }
        return answer;
    }

    public int solution2(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }


    // 입력 값은 100,000가 최대이다.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        int N = in.nextInt();
        int M = in.nextInt();
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = in.nextInt();
        }

        System.out.println(T.solution(N, M, list));
    }
}
