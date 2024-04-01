package 프로그래머스.기초문제.Day3.문자열섞기;

class Solution {
    // 내가 푼 방식
    public static String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        // 문자열을 인덱스로 접근하기 위해서 배열로 변환
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        // for문
        for(int i = 0; i < arr1.length; i ++){
            // arr1[i] + arr2[i]를 하니까 제대로 문자열이 추가되지않음
            answer.append(arr1[i]); // StringBuilder로 각각 추가
            answer.append(arr2[i]);
        }
        // StringBuilder이기 때문에 toString을 해서 반환
        return answer.toString();
    }

    // CharAt을 사용한 솔루션
    public static String solution2(String str1, String str2){
        String answer = "";
        
        for(int i = 0; i < str1.length(); i++){
            answer += str1.charAt(i); // charAt으로 인덱스의 문자를 가져올 수 있음
            answer += str2.charAt(i);
        }
        
        return answer;
    };

    public static void main(String[] args) {
        System.out.println(solution("aaaaa","bbbbb"));
    }
}