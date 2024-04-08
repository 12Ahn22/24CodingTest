```java
    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        input = input + " ";
        int cnt = 1;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) cnt++;
            else {
                answer.append(input.charAt(i));
                if (cnt > 1) answer.append(cnt);
                cnt = 1;
            }
        }
        return answer.toString();
    }
```
- 복잡하게 생각하지 않기.
- 현재 인덱스와 바로 앞 인덱스의 문자를 비교할 때, 맨 마지막 인덱스는 다음 인덱스가 없기때문에 에러가 발생한다.
- 그래서 `input = input + " "`를 해줘서 마지막에 빈 문자를 가진 index를 추가해준다.