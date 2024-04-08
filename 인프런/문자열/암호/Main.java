package 인프런.문자열.암호;

import java.util.Scanner;

public class Main {
    public String solution(int N ,String input) {
        // input을 7자리씩 잘라서 decode하기.
        String[] codes = new String[N];
        // N
        for (int i = 0; i < N; i++) {
            codes[i] = input.substring(i * 7, (i + 1) * 7);
        }

        // N
        StringBuilder answer = new StringBuilder();
        for (String code : codes) {
            answer.append(decode(code));
        }

        return answer.toString();
    }
    public char decode(String code) {
        // 1. #****##를 2진수로 변환 (무조곤 7자리)
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : code.toCharArray()) {
            if (ch == '#') stringBuilder.append(1);
            else stringBuilder.append(0);
        }
        // 2. 2진수를 10진수로 변환
        int decimal = Integer.parseInt(stringBuilder.toString(), 2); // 67
        // 3. 10진수들을 문자로 변환
        return (char) decimal;
    }

    public String solution2(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            // 문자열을 잘라서 #과 *를 replace
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2); // 2진수를 10진수로 변환
            answer += (char) num;
            s = s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextInt(),in.next()));
        // System.out.println(T.solution("#****###**#####**#####**##** "));
    }
}
