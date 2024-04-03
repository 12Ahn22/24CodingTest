```java
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
```
## POS를 이용한 방법
> split을 사용하면 편리하지만, pos를 이용한 이유는 이전에 pos 방식으로 이용해 무언갈 찾던 로직이 있던것같아서이다.
> 
> Pos가 계속 이동하고, 원본이 바뀐다는 사실을 꼭 기억하기