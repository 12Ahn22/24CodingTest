package 코딩테스트합격자되기.배열.배열정렬하기;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
    }

    public Integer[] solution(Integer[] arr) {
        Integer[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }

    public Integer[] bubbleSort(Integer[] arr) {
        Integer[] clone = arr.clone();
        int n = clone.length;

        // 처음부터 끝까지 순회
        for (int i = 0; i < n; i++) {
            // 처음부터 ~ 뒤에 정렬된 직전까지 순회
            // 돌면서 만약 j 번째 값이 바로 앞의 값보다 크다면
            // 자리를 바꿈
            for (int j = 0; j < n - i - 1; j++) {
                if (clone[j] > clone[j + 1]) {
                    int tmp = clone[j];
                    clone[j] = clone[j + 1];
                    clone[j + 1] = tmp;
                }
            }
        }
        return clone;
    }
}
