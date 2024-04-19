```java
    public String solution(String[] input) {
        Map<String, Integer> result = new HashMap<>();

        for (String i : input) {
            result.put(i, result.getOrDefault(i,0) + 1);
//            if (!result.containsKey(i)) {
//                result.put(i, 1);
//            } else {
//                int prev = result.get(i);
//                result.put(i, prev + 1);
//            }
        }

        // Map에서 value가 가장 큰 키를 반환하기
        return result.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
```

## getOrDefault() 메서드
```java
default V getOrDefault(Object key, V defaultValue) {
    V v;
return (((v = get(key)) != null) || containsKey(key))
    ? v
    : defaultValue;
}
```
> Returns the value to which the specified key is mapped, 
> or defaultValue if this map contains no mapping for the key.

특정 `key`에대한 값을 반환한다. 그러나 해당 키에 mapping되는 것이 없다면 설정한 `defaultValue`를 제공한다.
### 사용한 코드
```java
result.put(i, result.getOrDefault(i,0) + 1);
```

## Stream으로 처리하기
```java
result.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
```
1. `.entrySet()` : Map에서 key-value를 나타내는 Set<Map.Entry<String,Intger>>을 반환한다.
2. `.max(Map.Entry.comparingByValue())`
   - 내가 필요한 정보는 구한 entrySet에서 value가 가장 큰 정보이다.
   - 따라서 max에게 넘겨줘야하는 인자 Comparator를 미리 선언되어있는 comparingByValue를 사용했다.
3. `.map(Map.Entry::getKey)`
    - 최댓값을 갖는 Map.Entry 객체를 찾은 후, 해당 객체의 key 값을 얻는다. 
4. `.orElse(null)`
   - .map이 Optional을 반환한다. Optional을 다루기 위해서 orElse를 사용했다.
   - Entry를 찾지 못했다면 null을 반환하도록 한다.