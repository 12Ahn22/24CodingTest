package 코딩테스트합격자되기.스택.진수변환;

import java.util.Stack;

public class Main {
    public String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();

        // 10진수를 2진수로 변환하는 방법
        while(decimal > 1){
            int quotient = decimal / 2;
            int mod = decimal % 2;
            stack.push(mod);
            decimal = quotient;
        }
        stack.push(decimal); // 마지막 1 넣기
        return stackToString(stack);
    }

    public <T> String stackToString(Stack<T> stack){
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            T element = stack.pop();
            sb.append(element.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main T = new Main();
        System.out.println(T.solution(10));
        System.out.println(T.solution(27));
        System.out.println(T.solution(12345));
    }
}
