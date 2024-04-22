```java
    // 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true
    // 입력 값 1,000,000이 최대 => 시간복잡도 생각해야함.
    public boolean solution(String[] phone_book) {
        // 전부다 검사하는 건 입력값이 터져서 안된다.
        // 총 전화번호 글자 수는 1~20
        Map<String, Integer> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, 1);
        }

        for (String phone : phone_book) {
            // 자기 길이만큼...for문?
            for (int i = 0; i < phone.length() - 1; i++) {
                // 자기를 자른 문자가 map에 있으면 false
                String sub = phone.substring(0, i + 1); // 0 ~ i 까지 자름
                if(map.containsKey(sub)) return false;
            }
        }
        return true;
    }
```
## substring(시작, 포함안하는끝)
```java
String substring(int beginIdx, int endIdx);
```
substring은 마지막 idx를 포함하지 않는 다는 점을 기억하자.

## 문제 해결 과정
### 입력값
**입력값의 크기가 1 이상 1,000,000이하**
  - 즉, 이중 for문을 사용하면 시간 초과가 발생한다.

### 내가 생각한 로직
1. 전화번호의 길이는 1~20이다. 즉, 만약 반복을 돌더라도 1~20번까지만돈다. 
2. 그러니 일단 전화번호를 전부 `map`에 등록한다.
3. 전화번호부를 다시 순회한다.
   - 현재 전화번호를 잘라서 순회한다.
   - 아무리 길어봤자 1~20회이다.
   - 자기 자신은 포함하지않아야하기때문에 자기 자신의 전 까지만 순회
4. 만약 순회 중에 이미 map 에 있는 key값이 있다면, 접두어이다.