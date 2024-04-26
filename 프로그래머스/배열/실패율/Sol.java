package 프로그래머스.배열.실패율;

import java.util.HashMap;
import java.util.Map;

public class Sol {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2]; // stages에는 1 이상 N + 1 이하의 자연수
        for(int i = 0; i < stages.length; i++){
            // 현재 스테이지에 도전하는 사람의 수를 구함
            challenger[stages[i]] += 1;
        }

        // 스테이지 별 실패한 사용자 수
        Map<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 각 스테이지를 순회하며 실패율 계산
        for(int i = 1; i <= N; i++){
            if(challenger[i] == 0){
                // 도전자가 없는 경우 = 실패율은 0
                fails.put(i, 0.);
            }else{
                // ex.
                // 1 스테이지에 도달한 사용자 = 총 스테이지 도달자 개수
                // 2 스테이지에 도달한 사용자 = 총 스테이지 도달자 개수 - 1스테이지 도달자
                // 3 스테이지에 도달한 사용자 = 총 스테이지 도달자 - 1,2번째 스테이지에 있는 사용자
                // ...
                fails.put(i, challenger[i] / total); // 실패율을 구한 후에
                total -= challenger[i]; // 1 스테이지 도달자를 빼면 -> total은 2스테이지 도달자 명수가 된다.
            }
        }
        return fails.entrySet().stream()
                .sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        Main T = new Main();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        T.solution(N, stages);
    }
}
