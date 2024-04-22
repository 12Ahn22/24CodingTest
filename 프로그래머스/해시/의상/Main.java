package 프로그래머스.해시.의상;

import java.util.*;

public class Main {
    // 서로 다른 옷의 조합의 수를 반환하시오

    /**
     * 수학 공식을 사용해서 푸는 코드
     */
    public int solution(String[][] input) {
        // 한 의상 부위당 하나만 사용 가능
        // 1. 의상을 카테고리 별로 뽑아서 정리
        // {face: ["...","..."], headgear: ["..."]}
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for (String[] v : input) {
            List<String> list = null;
            if (map.containsKey(v[1])) {
                list = map.get(v[1]);
            } else {
                list = new ArrayList<>();
            }
            list.add(v[0]);
            map.put(v[1], list);
        }

        for (List<String> v : map.values()) {
            answer = answer * (v.size() + 1);
        }

        return answer - 1;
    }

    /**
     *
     */
    public int solution2(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        // 모든 옷의 종류를 순회
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1]; // 옷의 타입
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        } // map은 옷의종류-개수 구조를 가지게됨
        
//        맨처음 시작을 1로 한 건 각 카테고리마다의 옷의 개수를 곱해줄거기 때문에 그런거에요.
//        카테고리마다 선택할 수 있는 경우의 수는 해당 옷의 개수 + 안입는 경우 하나 이므로 카테고리 당 옷의 개수 + 1을 곱해주고, 전부다 안 입는 경우를 마지막에 빼준거에요!
        for (Integer integer : map.values()) {
            answer *= integer + 1;
        }
        return answer - 1;
    }


    public static void main(String[] args) {
        String[][] test = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Main main = new Main();
        System.out.println(main.solution(test));
    }
}
