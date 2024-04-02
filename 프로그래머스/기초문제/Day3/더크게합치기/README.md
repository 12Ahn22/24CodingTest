## toString()과 String.valueOf()
### toString()
- Object에 기본적으로 있는 메서드
- 대상이 null이면 Null PointerException를 발생시킨다.
### String.valueOf(obj);
- String.valueOf(obj) 형식으로 사용
- 대상이 null이면 "null"이라는 문자열을 반환한다.

> 아직 어떤게 좋다 나쁘다는 잘 모르겠다.
> 아래 블로그 글을 보면, toString은 디버깅 용도로 만들어졌고 사용하는게 좋다고 한다.
>
> https://hudi.blog/java-correct-purpose-of-tostring/
> 

그럼 valueOf를 사용하는 게 좋은건가? valueOf를 사용하면 NPE가 발생하지 않기때문에 더 편리하다고 이야기하지만,
나는 왜 NPE가 발생하지 않은게 편리한지 모르겠다.

예상하지않은 Null값이라면, 예외를 던져서 처리하는 게 맞지않은가? 자바의 길은 멀고 험하다.

