# StringBuilder?
> 문자열을 다루는 코드를 보면 StringBuilder를 많이쓰는 것 같다.

> 자바에서 문자열은 수정이 불가능하다. 그래서 문자열을 더하면 계속 새로운 문자열 객체를 생성하게 된다.
>
> 이렇게 되면 수많은 문자열 객체들이 GC가 작동하기 전까지 계속 Heap 영역에 쌓이게 된다.
> 이런 자원 낭비를 막기 위해서 Java에서는 StringBuilder와 StringBuffer를 제공한다.
> 
> 두 클래스의 차이는 동기화, Thread-safe 차이이다. 보통 코딩테스트는 동기화를 지원하지 않는 StringBuilder를 많이 사용한다.
> 
> https://www.codejava.net/java-core/the-java-language/why-use-stringbuffer-and-stringbuilder-in-java
> 
> https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html


