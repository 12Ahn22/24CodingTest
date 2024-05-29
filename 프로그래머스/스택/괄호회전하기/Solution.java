package 프로그래머스.스택.괄호회전하기;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    // s를 왼쪽으로 회전시켰을 때, 올바른 괄호 문자열이 되는 경우의 개수를 구하기
    public static int solution(String s) {
        int answer = 0;

        // 1. 문자열 회전시키기 - 맨 앞 문자를 잘라서 맨 뒤에 붙이는 거임
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < s.length(); i++){
            System.out.println(sb.toString());
            if(isValid(sb.toString())) answer++;
            char first = sb.charAt(0); // 첫번째 문자
            sb.deleteCharAt(0);
            sb.append(first);
        }

        return answer;
    }

    // O(N) - s의 길이만큼 for문을 반복한다.
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> checkList = List.of('{', '[', '(');
        Map<Character,Character> map = Map.of('}','{',']','[',')','(');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (checkList.contains(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                char pop = stack.pop(); // { , [ , (
                if(!map.get(ch).equals(pop)) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(){{"));
    }
}
