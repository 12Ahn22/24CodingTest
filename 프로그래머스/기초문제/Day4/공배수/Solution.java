package 프로그래머스.기초문제.Day4.공배수;

public class Solution {
    public int solution(int number, int n, int m) {
        // 삼항 연산자 사용
        return (number%n == 0 && number%m == 0) ? 1 : 0;
    }
}
