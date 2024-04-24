package 프로그래머스.배열.두개뽑아서더하기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public int[] solution(int[] numbers) {
        // 입력 개수가 적음
        // 모든 수를 배열에 담고 오름차순
        // 중복 x - 쉬운 문제라도 이런 함정이 있으니 문제를 잘 분석하자.
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                answer.add(numbers[i] + numbers[j]);
            }
        }
        return answer.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }

    // 중복 제거를 위해서 Set을 사용하는 방법
    public int[] solution2(int[] numbers) {
        // 입력 개수가 적음
        // 모든 수를 배열에 담고 오름차순
        // 중복 x - 쉬운 문제라도 이런 함정이 있으니 문제를 잘 분석하자.
        Set<Integer> set = new HashSet<>();

        // O(N^2)
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        // set도 스트림을 사용하면 정렬을 할 수있게되는구나..!
        // N^2개의 데이터를 정렬 -> O(N^2 long N^2)
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
        // 따라서 총 N^2 log (N^2)
    }
}
