package 인프런.문자열.숫자만출력;

import java.util.Scanner;

public class Main {
    public int solution(String input) {
        // 문자와 숫자가 섞인 문자열에서 숫자만 출력해,
        StringBuilder stringBuilder = new StringBuilder();
        for(Character ch: input.toCharArray()){
            // isDigit은 숫자인지 여부를 판단해준다.
            if(Character.isDigit(ch)){
                stringBuilder.append(ch);
            }
        }
        // 해당 숫자 순서대로 자연수를 만든다.
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextLine()));
    }
}
