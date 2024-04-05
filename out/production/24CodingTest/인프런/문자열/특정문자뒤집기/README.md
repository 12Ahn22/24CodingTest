```java
    public String solution(String str) {
        // 문자열 순회
        char[] charArr = str.toCharArray();
        // 위치를 가리키는 포인터 2개
        int front = 0, end = str.length() - 1;
        char temp;
        // 문자열이면 이동 -> 자리 바꾸기
        while (front < end){
            // 앞에가 문자열이면,
            if(Character.isAlphabetic(charArr[front])){
                // 뒤에 위치 검사
                if(Character.isAlphabetic(charArr[end])){
                    // 둘이 자리 바꾸기
                    temp = charArr[front];
                    charArr[front] = charArr[end];
                    charArr[end] = temp;
                    front++;
                }
                end--;
            }else front++;
        }
        return new String(charArr);
    }
```
## 양 끝에서 시작해서 만나면 종료하는 while
> 자리를 바꾸거나 정렬해야하는 경우, 포인터를 2개 사용해서 비교하는 방법을 자주 사용하는 것 같다.

