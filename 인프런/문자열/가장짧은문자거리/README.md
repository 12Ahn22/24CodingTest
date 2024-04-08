## 앞에서부터 검사하고 뒤에서부터 검사하기
내가 기존에 푼 방식은 O(N^2)의 시간 복잡도를 가지고 있다.
```java
    public int[] solution(String S, String E) {
        //한 개의 문자열 s와 문자 t가 주어지면,
        // 문자열 s의 각 문자가 문자 t와 떨어진 최소 거리를 출력하는 프로그램

        int[] arr = new int[S.length()];
        Arrays.fill(arr, Integer.MAX_VALUE); // 배열 초기화

        int pos = S.indexOf(E);
        // O(N^2)겠지?
        while (pos != -1) {
            for (int i = 0; i < S.length(); i++) {
                int cur = Math.abs(pos - i);
                if (arr[i] > cur) {
                    arr[i] = cur;
                }
            }
            pos = S.indexOf(E, pos + 1);
        }
        // 문자열에서 E 위치를 찾는다.
        // E의 위치와 현재 문자열을 비교해서 배열에 해당 문자와 거리를 기록한다.
        // 다음 E 위치를 찾는다 -> 위 과정을 반복한다.
        // E가 더이상 없다면 작업 종료
        // 배열을 String으로 변환

        return arr;
    }
```
- while문은 비교할 문자가 있으면 계속 비교한다. 최악의 상황이면 N번 해야하기 때문에 N
- for문은 입력 문자열의 길이만큼 반복한다. 따라서 N
- 위 두 구문이 중첩되어있기 때문에 `O(N^2)`가 된다.

> `O(N^2)`은 정말 좋지 않은 시간 복잡도이다. 따라서 위 풀이는 답일지라도 좋지않다.

## 강의 코드
```java
    public int[] solution2(String s, char t) {
        int[] answer = new int[s.length()];
        // MAX_VALUE를 쓰지못하는 이유
        // p++; 로직에서 Overflow가 발생해서 값이 잘못 출력된다.
        int p = 1000;
        // 앞쪽부터 -> 뒤까지 순회를 돌면서
        // answer 배열을 채운다.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;
        // 다시 뒤쪽부터 -> 앞으로 가면서
        // 검사를 하는데, 값이 작은 걸 저장한다.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) p = 0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
```
- **강의 코드를 보면, `중첩된 반복문`을 `쪼갠 것`을 볼 수 있다.**
  - 중첩된 반복문을 쪼개면 O(N^2)를 O(N) + O(N)으로 만들 수 있다.
  - 2O(N) => O(N)이 된다!
- **p 값이 1000인 이유**
  - 문제의 제약 조건에서, 문자열은 100 길이가 넘지않는다고 쓰여있음
  - Integer.MAX_VALUE를 사용하려 했으나, for문 로직 내에 p++하는 로직이 있어서 MAX_VALUE에서 +1이 되는 순간 int가 허용하는 숫자값을 벗어나게된다.
  그래서 제대로 된 값이 출력되지않은 문제가 발생했음