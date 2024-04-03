```java
    public ArrayList<String> solution2(int n, String[] str){
    ArrayList<String> answer=new ArrayList<>();
    for(String x : str){
        String tmp= new StringBuilder(x).reverse().toString();
        answer.add(tmp);
    }
    return answer;
}
```

## StringBuilder().reverse()
> 생각보다, StringBuilder에서 기본적으로 제공하는 메서드가 많은 것 같다.
> 
- StringBuilder는 문자열을 다루는 메서드라서 관련된 다양한 메서드가 있다.

- StringBuilder는 기존의 String을 변경하면서 새로운 객체 생성을 하지 않는다. 
- 즉, StringBuilder는 생성된 객체 하나를 계속 사용한다.

- 단, String으로 마지막에 변환해줘야한다.
```java
    String tmp= new StringBuilder(x).reverse().toString();
```