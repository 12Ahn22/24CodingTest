## 슬라이드 윈도우
### 코드
```java
public int solution2(int N, int K, int[] sales) {
// 0~K까지 더한 값을 max로 설정하기
int[] splitSales = Arrays.copyOfRange(sales, 0, K);
int sum = Arrays.stream(splitSales).sum();
int max = sum;

int startIdx = 0;
int endIdx = K;
while (endIdx < N - K) {
    // 맨 앞 요소를 빼고,
    // 다음 IDX 요소를 더한다.
    sum += sales[endIdx++] - sales[startIdx++];
    max = Math.max(sum, max);
}
return max;
}
```

### 입력값 신경 쓰기
> **입력**
> 
> 첫 줄에 N `(5<=N<=100,000)`과 K `(2<=K<=N)`가 주어집니다.

즉, 최대 입력인 100,000인 경우 `이중for`문을 도는 경우 100,000 * 100,000 가 된다.

| 시간 복잡도 | 	최대 연산 횟수 |
|------|-----------|
|O(N!) | 	10       |
|O(2^N)| 	20~25    |
|O(N^3)|	200~300|
|O(N^2)|	3,000~5,000|
|O(NlogN)|	100만|
|O(N)|	1,000~2,000만|
|O(logN)|	10억|
 
위 표를 보면, `O(N^2)` 시간 복잡도를 가지는 경우 최대 연산 횟수는 `3,000 ~ 5,000`이다.

이미 아득하게 연산 범위를 넘어버리기 때문에 내가 처음 작성한 2중 for문 로직으로는 **시간 초과**로 인한 오답처리가 발생한다.

입력 값의 최대값은 100,000이다. 즉, 10만을 넘기지않는 시간 복잡도여야한다.

따라서 `NlogN`, `N`, `logN`인 시간 복잡도를 가져야한다.

### 슬라이드 윈도우
