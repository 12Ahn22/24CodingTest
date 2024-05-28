package 코딩테스트합격자되기.스택.진수변환;

import java.util.Stack;

public class Solution {
    public static String solution(int decimal){
        Stack<Integer> stack = new Stack<>();

        while(decimal > 0){
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal = decimal / 2;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
