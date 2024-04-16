```java
    public int solution2(int n, int[][] arr) {
        // 확인해야하는 4방향을 위한 증감값을 배열로 설정해놓는다.
        // 이걸 초기화 해놓고 for문을 돌리는 방식으로 상하좌우를 확인한다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        // 2차원 배열 순회를 위한 2중 for문 i와 j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true; // 하나의 격자라도 틀리면 false 처리하기 위한 플래그
                for (int k = 0; k < 4; k++) { // 4방향 확인을 위한 for문
                    int nx = i + dx[k]; // row 좌표
                    int ny = j + dy[k]; // col 좌표
                    // if문은 좌표가 터지는 것을 방지함
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        // 상하좌우의 값이 현재 위치 arr[i][j]보다 크면, 현재 위치는 봉우리가 아니다.
                        flag = false; // false 처리
                        break; // 하나라도 false가 나오면 4방향 검사를 하는 for문을 break한다.
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }
```
## 배열 요소의 주변을 검사하는 방법
1. 방향을 결정하는 `증감값`을 `배열`로 미리 설정해놓는다.
2. 해당 `배열을 순회`하면서 검사를 한다.

```java
// 확인해야하는 4방향을 위한 증감값을 배열로 설정해놓는다.
// 이걸 초기화 해놓고 for문을 돌리는 방식으로 상하좌우를 확인한다.
int[] dx = {-1, 0, 1, 0};
int[] dy = {0, 1, 0, -1};
```
> 만약, 8방향을 검사해야한다면 dx, dy의 요소가 8개가 되면 된다.

