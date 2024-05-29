package 코딩테스트합격자되기.스택.괄호회전하기;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 문자열 돌리는 걸 다른 식응로 해봄. 그런데 StringBuilder가 더 빠른듯
 */
public class Solution2 {
    // s를 왼쪽으로 회전시켰을 때, 올바른 괄호 문자열이 되는 경우의 개수를 구하기
    public static int solution(String s) {
        int answer = 0;

        // 1. 문자열 회전시키기 - 맨 앞 문자를 잘라서 맨 뒤에 붙이는 거임
        int n = s.length(); // 문자열의 길이
        s += s; // 문자열 길이를 2배 시킴
        for (int i = 0; i < n; i++) {
            if (isValid(s.substring(i, i + n))) answer++;
        }

        return answer;
    }

    // O(N) - s의 길이만큼 for문을 반복한다.
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> checkList = List.of('{', '[', '(');
        Map<Character, Character> map = Map.of('}', '{', ']', '[', ')', '(');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (checkList.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop(); // { , [ , (
                if (!map.get(ch).equals(pop)) return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(){{"));
    }
}
