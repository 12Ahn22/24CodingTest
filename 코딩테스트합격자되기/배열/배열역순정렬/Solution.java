package 코딩테스트합격자되기.배열.배열역순정렬;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    public static int[] solution(int[] input) {
        Integer[] res = Arrays.stream(input).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(res, Collections.reverseOrder());
        return Arrays.stream(res).mapToInt(Integer::intValue).toArray();
    }
}
