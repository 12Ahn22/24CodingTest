package 인프런.문자열.문장속단어;

import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String answer = "";
        // 단어들은 모두 공백으로 쪼개진다.
        String[] list = str.split(" ");
        for (String word : list) {
            if (word.length() > answer.length()) answer = word;
        }
        return answer;
    }

    // POS를 사용한 방법
    public String solution2(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE, pos; // pos가 위치를 계속 이동함
        // indexOf는 입력받은 문자를 처음 만나는 시작 위치 index를 반환한다.
        while ((pos = str.indexOf(' ')) != -1) { // 만약 없다면 -1을 반환한다.
            String tmp = str.substring(0, pos); // 문자를 pos까지 자름
            int len = tmp.length(); // 길이 비교
            if (len > max) {
                max = len;
                answer = tmp;
            }
            // 그리고 다음 문자를 찾기 위해 str을 자름
            str = str.substring(pos + 1);
        }
        // 마지막에 남은 단어를 비교하기 위한 if문
        if (str.length() > max) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        System.out.println(T.solution(in.nextLine())); // next가 아닌 nextLine을 써야한다.
    }
}
