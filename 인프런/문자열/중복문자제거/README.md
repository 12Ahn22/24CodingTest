## Set을 사용해 contains 비교에 대한 시간 복잡도를 줄이기
```java
    // Set을 사용한 시간복잡도 향상
    public String solution(String str) {
        List<String> input = Arrays.asList(str.split(""));
        List<String> answer = new ArrayList<>();
        answer.add(input.getFirst());
        
        // 빠른 검색을 위한 Set 선언
        Set<String> seen = new HashSet<>();
        seen.add(input.getFirst());

        // O(N)
        for (String letter : input) {
            // contain을 하는 부분을 set을 사용함 O(1)
            if (!seen.contains(letter)) {
                answer.add(letter);
                seen.add(letter);
            }
        } // 따라서 총 O(N)
        return String.join("", answer);
    }
```
> 기존에 내가 사용한 방법은 List로 만들어서 해당 리스트에 letter가 있는지 확인하는 방법을 사용한다.

그러나 ArrayList의 `.contains(letter)` 메서드는 O(N)의 시간 복잡도를 가진다.
- 왜냐면 List이기 때문에 앞쪽부터 순차적으로 비교하기 때문이다.

따라서 Set을 이용해 `.contains`을 확인하는 방법을 추가했다.

Set의 contains 메서드는 O(1)의 시간 복잡도를 가진다.
- 중복이 x, 해당 값이 키이기 때문.

## indexOf 를 사용하는 방법
```java
    public String solution3(String str){
        String answer="";
        for(int i=0; i<str.length(); i++){
            // 현재 단어의 위치가 i랑 같다면 추가해라.
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }
        return answer;
    }
```

indexOf를 사용하면 문자열에서 찾는 문자열의 index를 얻는다.
- 이때, index는 해당 문자가 발견되는 가장 처음이다.

따라서 for문을 돌 때, 해당 문자를 indexOf했을 때 그 값이 i 와 같다면 문자가 첫 등장한 것이다.
- 문자가 첫 등장하면 answer에 추가
- 아니라면 넘김
