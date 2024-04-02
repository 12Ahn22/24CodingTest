package 프로그래머스.기초문제.Day3.문자리스트를문자열로;

public class Solution {
    public String solution(String[] arr) {
        // 문자열의 추가가 계속 일어나기 때문에 StringBuilder를 씀
        StringBuilder answer = new StringBuilder();
        for(String v: arr){
            answer.append(v);
        }
        return answer.toString();
    }

    public String solution2(String[] arr) {
        // String에서 join메서드를 제공하는 지 몰랐다!
        return String.join("", arr);
    }
}