package 인프런.문자열.문자열압축;

import java.util.Scanner;

public class Main {
    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        input = input + " ";
        int cnt = 1;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) cnt++;
            else {
                answer.append(input.charAt(i));
                if (cnt > 1) answer.append(cnt);
                cnt = 1;
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        System.out.println(T.solution(in.nextLine()));
    }
}
