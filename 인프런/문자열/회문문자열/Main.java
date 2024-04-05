package 인프런.문자열.회문문자열;

import java.util.Scanner;

public class Main {
    // 앞에서 읽나 뒤에서 읽나 같은 문자열이 회문이다.
    // 대소문자 구분 X
    // 회문이면 YES, 아니면 NO
    public String solution(String input) {
        // 대소문자를 구분하지 않기
        String upperInput = input.toUpperCase();
        int start = 0, end = upperInput.length() - 1;
        // O(N)
        while (start < end) {
            // 각 자리 문자 비교
            if (!(upperInput.charAt(start) == upperInput.charAt(end))) {
                return "NO";
            }
            start++;
            end--;
        }
        return "YES";
    }

    // 절반만 비교하면 된다..!
    public String solution2(String str) {
        String answer = "YES";
        str = str.toUpperCase(); // 대소문자 구분없게 하기위한 모두 대문자 처리
        int len = str.length(); // 문자열 길이

        // 절반만 비교하면 된다. : 양쪽에서 서로만나면 끝나야하니까.
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                answer = "NO";
                break;
            }
        }
        return answer;
    }

    // StringBuilder에 있는 메서드 사용하기
    public String solution3(String str) {
        String answer = "NO";
        // 글자를 뒤집었는데 같다면? 팰린드럼
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextLine()));
    }
}
