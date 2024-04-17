## 정답 여부 ❌

## 정리
### 접근 방법
- **학생을 학생과 비교해야한다.** 
  - 즉, 학생이 `[1,2,3,4]` 총 4명이라면, 
    - 4 * 4 비교를 해야한다.
    - 이는 `2중 for문`을 의미한다.
- **비교해야하는 것이 무엇인가?**
  - 시험 점수들을 비교해야한다. 즉, 학생 i와 학생j를 비교할 때, 그들의 시험 점수를 전부 비교해야한다.
  - 시험이 3번을 봤다고 치면 시험 3번을 전부 확인해야한다.
    - `for(int k = 0; k < m; k++) 코드`
  - 시험에서의 학생 i와 학생 j의 등수를 기록한다.
  - 학생i의 등수가 학생 j의 등수보다 작다면(작은게 높은거다.)
    - cnt는 한 시험에서 학생i의 등수가 높다면 증가가 된다.
    - 즉, 모든 시험에서 학생 i가 학생 j보다 등수가 높다면 cnt는 시험의 횟수의 값과 같아진다!
- **학생 i와 학생 j의 시험 결과에 대한 비교가 끝났다면, cnt의 값과 m의 값을 비교한다.**
  - cnt와 m이 같다면, 학생 i는 모든 시험에서 학생 j보다 높은 등수라는 의미다.

### 강의 코드
```java
// n - 학생 수, m - 시험 수
public int solution(int n, int m, int[][] arr) {
    int answer = 0;

    // 학생으로 2중포문을 도는 이유
    // 총 학생이 4명일 때, - 학생 1은 학생 (1),2,3,4에 대해서 전부 비교해야한다.
    for (int i = 1; i <= n; i++) { // 비교할 학생 i
        for (int j = 1; j <= n; j++) { // 비교할 학생 j
            int cnt = 0;

            // 그리고 해당 학생들의 시험 점수를 전부 비교해야한다.
            for (int k = 0; k < m; k++) { // 시험 수
                int pi = 0, pj = 0;

                // 한 시험에 대한 등수를 기록
                for (int s = 0; s < n; s++) { // 등수
                    if (arr[k][s] == i) pi = s; // i 학생의 등수를 기록한다.
                    if (arr[k][s] == j) pj = s; // j 학생의 등수를 기록한다.
                }
                // i 가 더 높은 등수라면
                if (pi < pj) cnt++; // ++
            }

            // 모든 시험에서 비교했을 때, cnt의 값이 m과 같다면,
            // i의 랭크가 j의 랭크보다 항상 큰 것이기 때문에
            // i는 j의 멘토가 될 수 있다.
            if (cnt == m) {
                answer++;
                //System.out.println(i+" "+j);
            }
        }
    }
    return answer;
}
```

### 3중 for문으로 변경한 방법
```java
// 3중 for문으로 푸는 방법
private static int solutionFor3(int n, int m, int[][] intArrArr) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            boolean flag = true;
            for (int k = 0; k < m; k++) {
                if (intArrArr[i][k] >= intArrArr[j][k]) {
                    flag = false;
                    break; // 한 번이라도 통과하지 못하면 break
                }
            }
            if (flag) {
                answer++;
            }
        }
    }
    return answer;
}
```