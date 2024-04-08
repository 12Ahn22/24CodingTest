```java
    public String solution(String input) {
        // 앞에서 읽으나 뒤에서 읽으나 같은 문자열 - 팰린드롬
        // 알파벳 이외의 문자를 무시한다.
        StringBuilder str = new StringBuilder();

        // 1. 입력받은 문자열에서 알파벳만 뽑아내기
        for (Character ch : input.toUpperCase().toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                str.append(ch);
            }
        }
        // 2. Reverse 했을 때, 같은 지 판단하기
        // str.reverse()는 기존 문자열도 리버스를 해버린다. 즉, str도 reverse 되버림.
        // String reversedStr = str.reverse().toString(); // 이렇게 하면 안됨
        String reversedStr = new StringBuilder(str).reverse().toString();

        return str.toString().equals(reversedStr) ? "YES" : "NO";
    }
```
## StringBuilder의 reverse
> StringBuilder의 reverse는 원본을 reverse한다!

원본을 reverse 시키기 때문에, str.reverse()와 str을 비교하니까 계속 같다고 출력되던 것이였다.
따라서, 새로운 StringBuilder 객체를 만든 후, 그걸 reverse 한 후 그 결과와 비교해야한다.

```java
String reversedStr = new StringBuilder(str).reverse().toString();
```