package 프로그래머스.기초문제.Day4.홀짝에따라다른값;

public class Solution {
    public static int solution(int n) {
        int answer = 0;
        boolean isEven = n % 2 == 0 ? true : false;

        if (isEven) {
            // 짝수라면 제곱의 합
            for(int i = 0; i <= n; i = i + 2){
                answer += (int) Math.pow(i,2);
            }
        } else {
            // 홀수라면 모든 수의 합
            for (int i = 1; i <= n; i = i + 2) {
                answer += i;
            }
        }
        return answer;
    }

    // 수학 공식이 따로 존재하나보다...
    public int solution2(int n) {
        if (n % 2 == 1) {
            return (n + 1) * (n + 1) / 2 / 2; // 홀수만 더하는 공식
        } else {
            return 4 * n/2 * (n/2 + 1) * (2 * n/2 + 1) / 6;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
