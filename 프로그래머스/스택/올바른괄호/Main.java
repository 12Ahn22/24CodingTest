package 프로그래머스.스택.올바른괄호;

import java.util.Stack;

public class Main {
    // 입력값 - 괄호 문자열
    // 출력 - 괄호의 짝이 맞는 경우에 true, 아니라면 false
    public boolean solution(String s) {
        // ( 열린 괄호를 만나면 stack에 하나를 넣는다.
        // ) 닫는 괄호를 만나면 stack에서 하나를 뺀다.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                // )를 만나면 짝이 맞는 (를 하나 꺼내야한다.
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
