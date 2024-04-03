```java
package 인프런.문자열.문자찾기;

import java.util.Scanner;

public class Main {
    // 프로그래머스 방식
    public int solution(String str, char t){
        int answer = 0;
        // 원활한 비교를 위해서 다 대문자로 변경
        str = str.toUpperCase();
        t = Character.toUpperCase(t); // Wrapper 클래스에 있는 메서드 사용하기
        // 문자열을 배열로 변환해서 향샹된 for문 사용하기
        for(char c:str.toCharArray()){
            if(c==t) answer++;
        }
        return answer;
    }

    // 근데 백준은 아래처럼해야해서 solution이라는 메서드로 따로 빼는거구나
    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        String input = in.next(); // next는 개행문자를 무시
        char c = in.next().charAt(0);
        System.out.println(T.solution(input, c));
    }
}
```
## Scanner의 next()와 nextline()의 차이점
- `next()`
  - 개행 문자를 포함하지 않는다.
- `nextLine()`
  - 개행 문자를 포함한다.

> \n와 같은 개행문자를 처리하지않기 위해서 next를 쓰는게 더 좋아보인다.