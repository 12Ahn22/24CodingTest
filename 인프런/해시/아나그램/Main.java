package 인프런.해시.아나그램;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // 아나그램인지 판단하는 프로그램
    // 아나그램이란?
    // - 알파벳의 순서 상관없이, 구성 요소가 같은것.
    //    = 사용한 알파벳의 개수가 같음

    // 입력 - 문자열 2개
    public String solution(String a, String b) {
        // 문자열 순회해 사용한 요소를 map에 기록(빈도수)
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            mapB.put(b.charAt(i), mapB.getOrDefault(b.charAt(i), 0) + 1);
        }

        // 두 문자열이 가진게 같은 지 확인
        if (mapA.size() != mapB.size()) return "NO";
        // 키를 순회를 돌면서 존재 여부 확인
        for (Character c : mapA.keySet()) {
            if (!mapA.get(c).equals(mapB.get(c))) return "NO";
        }
        return "YES";
    }

    // 강의 코드
    // map을 하나만 사용해 풀이한다.
    public String solution2(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextLine(), in.nextLine()));
    }
}
