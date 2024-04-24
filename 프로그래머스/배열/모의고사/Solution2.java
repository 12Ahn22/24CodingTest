package 프로그래머스.배열.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    // 가장 많이 답을 맞춘 사람을 배열에 담아 반환
    static public int[] solution(int[] answers) {
        // 시험은 최대 10000문제
        // 정답은 1~5
        // 가장 높은 점수가 여럿이면, 오름 차순 정렬로 여러명을 다 넣기

        // 수포자 1 - 1~5까지 순차적으로 반복
        // 수포자 2 - 첫번째는 2, 그다음은 1~5
        //      0포함 짝수는 모두 2, 나머지는 증가.
        // 수포자 3 - 33 11 22 44 55 로 반복
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 2, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < pattern.length; j++){
                // 수포자 패턴과 비교
                if(answers[i] == pattern[j][i % pattern[j].length]){
                    scores[j]++;
                }
            }
        }
        // 가장 높은 점수를 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 가장 높은 점수를 가진 수포자들의 번호를 리스트에 담기
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == maxScore){
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }
}