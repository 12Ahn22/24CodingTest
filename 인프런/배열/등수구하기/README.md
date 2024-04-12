```java
    /**
     * 시간복잡도: O(N log N)
     */
    public int[] solution2(int N, Integer[] input) {
        Integer[] sortedInput = input.clone();
        Arrays.sort(sortedInput, Collections.reverseOrder()); // 입력 배열을 정렬 (N log N)

        // 정렬된 순서에 맞게 등수를 설정
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for(int i = 0; i< N; i++){
            // 정렬된 순서대로, 값을 rankMap에 넣기
            if(!rankMap.containsKey(sortedInput[i])){
                rankMap.put(sortedInput[i], rank);
            }
            rank++;
        }

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = rankMap.get(input[i]);
        }

        return answer;
    }
```

## 시간 복잡도를 줄이기 위한 방법들
### 역순 sort를 쓰기
 
```java
@Contract(mutates = "param1")  
public static <T> void sort(@NotNull  T[] a, 
                            @Nullable  java.util.Comparator<? super T> c );
```
> `역순`이 아니라 오름 차순으로 정렬을 한다면 그냥 `sort`를 사용하면 된다.
> 그러나, 역순을 하기 위해서는 `Comparator`를 넘겨줘야한다.
> 
> 문제는, `Comparator`를 넘겨주는 sort 메서드를 사용하는 경우, 넘겨주는 배열의 타입이 `T[] a`가 된다는 것이다.
> T 제네릭에는 기본형 타입이 들어갈 수 없다.

- **Compartor란?**
  - 자바에서 정렬 기능을 사용하기 위해서는 해당 클래스가 `Comparable 인터페이스`의 구현체이거나, Comparator를 넘겨주어야한다.
