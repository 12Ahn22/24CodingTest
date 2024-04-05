package 인프런.문자열.중복문자제거;

import java.util.*;

public class Main {
    public String solution1(String str) {
        char[] charArr = str.toCharArray();
        StringBuilder answer = new StringBuilder();

        // 보통 내가 개수를 세는 걸 작업햇을 때는 객체를 사용했는데...흠;
        // 이러면 순서가 보장안됨....
        Set<Character> set = new HashSet<>();
        for(Character ch: charArr){
            set.add(ch);
        }
        for(Character e: set){
            System.out.println(e.charValue());
            answer.append(e.charValue());
        }

        // 제대로 중복 처리는 하지만 Set은 순서를 보장하지 못하기 때문에
        // 제대로된 순서로 값이 나오지 않는다.
        return answer.toString();
    }

    // 배열을 순회해서 확인하는 방법
    public String solution2(String str) {
        List<String> input = new ArrayList<>(List.of(str.split("")));
        List<String> answer = new ArrayList<>();
        answer.add(input.getFirst());

        // O(N)
        for(String letter: input){
            // O(N)
            // 내가 알기로 contains도 O(N)임. 앞쪽부터 순회니까
            if(!answer.contains(letter)){
                answer.add(letter);
            }
        }
        // 결국 총 O(N^2)임. for문 두번 중첩이니까..

        return String.join("",answer);
    }

    // Set을 사용한 시간복잡도 향상
    public String solution(String str) {
        List<String> input = Arrays.asList(str.split(""));
        List<String> answer = new ArrayList<>();
        answer.add(input.getFirst());
        
        // 빠른 검색을 위한 Set 선언
        Set<String> seen = new HashSet<>();
        seen.add(input.getFirst());

        // O(N)
        for (String letter : input) {
            // contain을 하는 부분을 set을 사용함 O(1)
            if (!seen.contains(letter)) {
                answer.add(letter);
                seen.add(letter);
            }
        } // 따라서 총 O(N)
        return String.join("", answer);
    }

    // 강의 코드
    public String solution3(String str){
        String answer="";
        for(int i=0; i<str.length(); i++){
            // 현재 단어의 위치가 i랑 같다면 추가해라.
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        // 소문자, 한줄 문자열 입력
        String str = in.nextLine();
        System.out.println(T.solution(str));
    }
}
