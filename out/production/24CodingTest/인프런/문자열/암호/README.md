```java
    public char decode(String code) {
    // 1. #****##를 2진수로 변환 (무조곤 7자리)
    StringBuilder stringBuilder = new StringBuilder();
    for (Character ch : code.toCharArray()) {
        if (ch == '#') stringBuilder.append(1);
        else stringBuilder.append(0);
    }
    // 2. 2진수를 10진수로 변환
    int decimal = Integer.parseInt(stringBuilder.toString(), 2); // 67
    // 3. 10진수들을 문자로 변환
    return (char) decimal;
}
```
## Integer.parseInt의 중요한 점
> `Integer.parseInt(문자열,radix);`

`Interger.parseInt(문자열,radix)`은 특정 문자열을 10진수 정수로 변환해주는 메서드이다.

즉, 여기서 쓰는 radix는 해당 진법의 숫자로 바꿔주는 것이 아니라, 문자열이 해당 문자열의 진법이 radix라는 의미이다.
```java
    int decimal = Integer.parseInt(stringBuilder.toString(), 2);
```
- 위 코드는 StringBuilder.toString()이 2진수 형태라는 것을 알려주는 것이다.