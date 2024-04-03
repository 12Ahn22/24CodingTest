```java
package 인프런.문자열.대소문자변환;

import java.util.Scanner;

public class Main {
    public String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for(char c: str.toCharArray()){
            if(Character.isLowerCase(c)) answer.append(Character.toUpperCase(c));
            else answer.append(Character.toLowerCase(c));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main T = new Main();
        String str = in.next();
        System.out.println(T.solution(str));
    }
}
```
## Stringbuilder 클래스
문자열 연산을 빈번하게 하는 경우 `StringBuilder`를 써야 성능이 더 좋다. `항상 기억하기!`
