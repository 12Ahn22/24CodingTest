package 프로그래머스.배열.실패율;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int[] solution(int N, int[] stages) {
        // 실패율? 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 사람 수
        // 전체 스테이지의 개수 N
        // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열stages
        //  - 인덱스가 사용자고 멈춰있는 스테이지가 값임(현재 도전중인 스테이지)
        // 실패율이 높은 스테이지부터 내림차순으로 스테이지 번호가 담긴 배열을 반환

        // 출력 - 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호 []

        // 3번 스테이지에 있다면 -> 1, 2 , 3 까지 도전한 것이고 3에서 막힌 것임

        // 1. 총 스테이지 별 도전자 수를 구함
        // 2. 총 스테이지 별 막혀있는 사람 수를 구함
        // 3. 그걸로 스테이지에서 막힌 실패율 계산
        // 4. 실패율 기준으로 내림 차순
        Map<Integer, Integer> allChallenger = new HashMap<>();
        for (int i : stages) { // Stages 입력값 만큼 O(N)
            for (int j = 1; j <= i; j++) {
                // 스테이지 i값까지 + 1 해줘야한다.
                allChallenger //
                        .put(j, allChallenger.getOrDefault(j, 0) + 1);
            }
        }

        Map<Integer, Integer> blockChallenger = new HashMap<>();
        for (int i : stages) { // O(N)
            blockChallenger
                    .put(i, blockChallenger.getOrDefault(i, 0) + 1);
        }

        Map<Integer, Double> fail = new HashMap<>();
        for (int i = 0; i < N; i++) { // O(N)
            int all = allChallenger.getOrDefault(i + 1, 0);
            int block = blockChallenger.getOrDefault(i + 1, 0);
            if (all == 0) {
                fail.put(i, (double) 0);
                continue;
            } // 예외

            double failure = (double) block / all;
            fail.put(i, failure);
        }

        // 자바 표준 API의 정렬은 N log N
        return fail.entrySet().stream().sorted((a, b) -> Double.compare(b.getValue(), a.getValue())).mapToInt(v -> v.getKey() + 1).toArray();
    }

    public static void main(String[] args) {
        Main T = new Main();
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        T.solution(N, stages);
    }
}
