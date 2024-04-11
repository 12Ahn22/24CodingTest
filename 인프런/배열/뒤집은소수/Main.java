package 인프런.배열.뒤집은소수;

import java.util.Scanner;

public class Main {

    // 입력받은 배열 중, 숫자가 소수면 출력
    public void solution(int N, String[] input) {
        for (int i = 0; i < N; i++) {
            // 요소를 뒤집기
            StringBuilder reversed = new StringBuilder(input[i]).reverse();

            // 문자로 만들기
            int num = Integer.parseInt(reversed.toString());

            // 소수 검사
            if (isPrime(num)) System.out.print(num + " ");
        }
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = Integer.parseInt(in.nextLine());
        T.solution(N, in.nextLine().split(" "));
    }
}
