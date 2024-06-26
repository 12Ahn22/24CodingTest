package 인프런.문자열.유효한팰린드롬;

import java.util.Scanner;

public class Main {
    public String solution(String input) {
        // 앞에서 읽으나 뒤에서 읽으나 같은 문자열 - 팰린드롬
        // 알파벳 이외의 문자를 무시한다.
        StringBuilder str = new StringBuilder();

        // 1. 입력받은 문자열에서 알파벳만 뽑아내기
        for (Character ch : input.toUpperCase().toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                str.append(ch);
            }
        }
        // 2. Reverse 했을 때, 같은 지 판단하기
        // str.reverse()는 기존 문자열도 리버스를 해버린다. 즉, str도 reverse 되버림.
        // String reversedStr = str.reverse().toString(); // 이렇게 하면 안됨
        String reversedStr = new StringBuilder(str).reverse().toString();

        return str.toString().equals(reversedStr) ? "YES" : "NO";
    }

    public String solution2(String s) {
        String answer = "NO";
        // 정규표현식을 사용한 replaceAll
        // 알파벳이 아닌 것들을 다 빈 문자로 replace 시키기
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if (s.equals(tmp)) answer = "YES";
        return answer;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextLine()));
    }
}
