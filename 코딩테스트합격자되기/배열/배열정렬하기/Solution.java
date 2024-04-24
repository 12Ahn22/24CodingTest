package 코딩테스트합격자되기.배열.배열정렬하기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
    }
    
    // 제약 조건
    // - 정수 배열의 길이는 2 이상 10^5이하
    // - 각 데이터 값은 - 100,000 이상 100,000 이하

    private static int[] solution(int[] arr) {
        Arrays.sort(arr); // sort는 원본 배열을 수정한다.
        return arr;
    }

    private static int[] solution2(int[] arr) {
        // 원본 배열을 변경하고 싶지않은 경우
        int[] clone = arr.clone(); // 타겟이 되는 배열을 복사해 새로운 배열로 생성
        Arrays.sort(clone);
        return clone;
    }
}
