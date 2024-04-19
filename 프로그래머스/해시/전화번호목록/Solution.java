package 프로그래머스.해시.전화번호목록;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true
    // 입력 값 1,000,000이 최대 => 시간복잡도 생각해야함.
    public boolean solution(String[] phone_book) {
        // 전부다 검사하는 건 입력값이 터져서 안된다.
        // 총 전화번호 글자 수는 1~20
        Map<String, Integer> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, 1);
        }

        for (String phone : phone_book) {
            // 자기 길이만큼...for문?
            for (int i = 0; i < phone.length() - 1; i++) {
                // 자기를 자른 문자가 map에 있으면 false
                String sub = phone.substring(0, i + 1); // 0 ~ i 까지 자름
                if(map.containsKey(sub)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = {"119", "97674223", "1195524421"};
//        String[] input = {"123", "456", "789"};
        System.out.println(new Solution().solution(input));
    }
}