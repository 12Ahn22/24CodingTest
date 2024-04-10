## 문자열 배열을 정수 배열로 변환하는 방법
### stream을 활용한 방법
```java
int[] list = 
        Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt).toArray();
```
input 예시 - `"120 130 140"`
`mapToInt()`메서드는 요소를 다른 요소로 변환한 새로운 **스트림**을 반환한다.

JS의 map과 거의 유사하니까 연관해서 생각하면 좋은 것 같다.

### for문을 사용하는 방법
```java
StringTokenizer tokenizer = new StringTokenizer(input);
int count = tokenizer.countTokens();
int[] list = new int[count];
for (int i = 0; i < count; i++) {
    list[i] = Integer.parseInt(tokenizer.nextToken());
};
```
자바 Tokenzier를 이용해, 문자열을 쪼갠다. 그 후 for문을 돌면서 하나씩 list에 설정해주는 방법이다.

### 어떤 방법이 더 좋나?
사람마다 어떤 방법이 더 편하냐는 다르겠지만, map과 같은 메서드를 사용하게 되면 실수를 줄일 수 있다고 생각한다.

mapToXXX를 메서드를 쓰게 되면 해당 메서드를 보자마자, 요소들을 다른 요소로 변환하는 구나를 쉽게 알 수 있어서 코드를 보기에 더 좋다.
