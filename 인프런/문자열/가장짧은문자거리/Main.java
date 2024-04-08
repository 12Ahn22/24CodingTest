package 인프런.문자열.가장짧은문자거리;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int[] solution(String S, String E) {
        //한 개의 문자열 s와 문자 t가 주어지면,
        // 문자열 s의 각 문자가 문자 t와 떨어진 최소 거리를 출력하는 프로그램

        int[] arr = new int[S.length()];
        Arrays.fill(arr, Integer.MAX_VALUE); // 배열 초기화

        int pos = S.indexOf(E);
        // O(N^2)겠지?
        while (pos != -1) {
            for (int i = 0; i < S.length(); i++) {
                int cur = Math.abs(pos - i);
                if (arr[i] > cur) {
                    arr[i] = cur;
                }
            }
            pos = S.indexOf(E, pos + 1);
        }
        // 문자열에서 E 위치를 찾는다.
        // E의 위치와 현재 문자열을 비교해서 배열에 해당 문자와 거리를 기록한다.
        // 다음 E 위치를 찾는다 -> 위 과정을 반복한다.
        // E가 더이상 없다면 작업 종료
        // 배열을 String으로 변환

        return arr;
    }

    // 강의 풀이
    public int[] solution2(String s, char t) {
        int[] answer = new int[s.length()];
        // MAX_VALUE를 쓰지못하는 이유
        // p++; 로직에서 Overflow가 발생해서 값이 잘못 출력된다.
        int p = 1000;
        // 앞쪽부터 -> 뒤까지 순회를 돌면서
        // answer 배열을 채운다.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;
        // 다시 뒤쪽부터 -> 앞으로 가면서
        // 검사를 하는데, 값이 작은 걸 저장한다.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) p = 0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        String S = in.next();
        String E = in.next();
        for (int i : T.solution2(S, E.charAt(0))) {
            System.out.print(i + " ");
        }
    }
}
