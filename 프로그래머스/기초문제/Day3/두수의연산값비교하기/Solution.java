package 프로그래머스.기초문제.Day3.두수의연산값비교하기;

public class Solution {
    // 더 크게 합치기를 참고
    public int solution(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);

        String strSum1 = strA + strB;
        return Math.max(Integer.parseInt(strSum1), 2 * a * b);
    }
}
