package 프로그래머스.해시.완주하지못한선수;

import java.util.*;

public class Main {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 참여자를 map으로 만듦
        Map<String, Integer> participantMap = new HashMap<>();
        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        // 완주자를 map으로 만듦
        Map<String, Integer> completionMap = new HashMap<>();
        for (String p : completion) {
            completionMap.put(p, completionMap.getOrDefault(p, 0) + 1);
        }

        // 완주자를 기준으로 값을 비교해서 다른 경우 - 완주를 하지 못한 선수
        for (String p : participant) {
            if (!participantMap.get(p).equals(completionMap.get(p))) return p;
        }
        return answer;
    }
}
