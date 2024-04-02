package 프로그래머스.기초문제.Day3.더크게합치기;

public class Solution {
    // 내 솔루션
    public static int solution(int a, int b) {
        // 문자열은 +를 하면 문자로 붙음
        // 둘 중, 더 큰 값으로 만들어야함
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int res1 = Integer.parseInt(strA+strB);
        int res2 = Integer.parseInt(strB+strA);
        return Math.max(res1,res2);
    }

    // 다른 사람 솔루션
    public int solution2(int a, int b) {
        // String.valueOf()
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);

        String strSum1 = strA + strB;
        String strSum2 = strB + strA;
        return Math.max(Integer.parseInt(strSum1), Integer.parseInt(strSum2));
    }

    public static void main(String[] args) {
        System.out.println(solution(1,23));
        System.out.println(solution(9,91));
    }
}
