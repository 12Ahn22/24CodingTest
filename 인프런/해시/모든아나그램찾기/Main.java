package 인프런.해시.모든아나그램찾기;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        
        // 애너그램을 위한 B 문자열의 단어 빈도수 구하기
        for (char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);

        int L = b.length() - 1;
        // 애너그램을 위해 B 문자열 개수 -1개만큼의 덩어리를 미리 구해놓기
        for (int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);

        int lt = 0;
        // 하나씩 이동하면서 덩어리를 이동하기 - 슬라이딩 윈도우
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            // HashMap은 equals로 비교가 된다.
            if (am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextLine(), in.nextLine()));
    }
}
