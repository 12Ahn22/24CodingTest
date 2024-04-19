package 인프런.해시.학급회장;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // 당선자를 고르는 문제
    // 후보는 A,B,C,D,E 로 고정되어있다.
    // 입력 -
    public String solution(String[] input) {
        Map<String, Integer> result = new HashMap<>();

        for (String i : input) {
            result.put(i, result.getOrDefault(i,0) + 1);
//            if (!result.containsKey(i)) {
//                result.put(i, 1);
//            } else {
//                int prev = result.get(i);
//                result.put(i, prev + 1);
//            }
        }

        // Map에서 value가 가장 큰 키를 반환하기
        return result.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // 강의 코드
    public char solution2(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        //System.out.println(map.containsKey('F'));
        //System.out.println(map.size());
        //System.out.println(map.remove('C'));

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            //System.out.println(key+" "+map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        in.nextLine();
        String[] input = in.nextLine().split("");

        System.out.println(T.solution(input));
    }
}
