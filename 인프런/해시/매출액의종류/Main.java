package 인프런.해시.매출액의종류;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // 입력값 - 100,000개 -> 이중포문 X
    //      N - 매출기록 개수, K - 연속될 기간, input 매출기록
    // 각 구간 별 매출액 종류 개수를 순서대로 출력
    public String solution(int N, int K, int[] input) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 매출기록은 전부 순회해야한다.
        // 순회 범위는 무조곤 K로 고정됨
        // 일단 첫번째 범위를 전부 넣어주기
        for (int i = 0; i < K; i++) {
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }
        list.add(map.size()); // 첫 덩어리 종류 개수 넣기

        // 다음 덩어리부터 계산 시작
        int lt = 0;
        for (int rt = K; rt < N; rt++) {
            // 기존 lt 자리에 있던 요소를 뺀다.
            map.put(input[lt], map.get(input[lt]) - 1);
            if (map.get(input[lt]) == 0) map.remove(input[lt]);
            lt++;
            // rt 자리에 있는 요소를 집어넣는다.
            map.put(input[rt], map.getOrDefault(input[rt], 0) + 1);
            // 덩어리 종류를 추가
            list.add(map.size());
        }

        // String으로 변환
        List<String> strList = list.stream().map(Object::toString).collect(Collectors.toList());
        return String.join(" ", strList);
    }

    // 훨씬 빠름!
    public ArrayList<Integer> solution2(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }


        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt]) - 1);
            if (HM.get(arr[lt]) == 0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        int N = in.nextInt();
        int K = in.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.nextInt();
        }
        System.out.println(T.solution(N, K, input));
    }
}
