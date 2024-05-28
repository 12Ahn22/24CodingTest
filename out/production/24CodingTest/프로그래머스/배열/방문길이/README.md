# 방문 길이
> 풀이 방법과 로직도 맞았지만, 결정적으로 표현을 못해서 틀린 문제

- 문제 이해 자체는 쉽지만 조건이 있었다.
    - **중복 경로를 최종 길이에 포함하지않는다는 조건**
    - 💡 중복을 포함하지 않는다는 문장이 나오면 `해시셋`을 생각하면 좋다.


  > 여기까진 생각하긴함 ㅜㅜ

- 해당 문제는 구현 문제이다.
    - 구현 문제는, 알고리즘 별다른 알고리즘 설명이 필요없다.
- 💡 그러나, 코드 자체가 길어지기때문에 `기능별로 함수를 구현`하는 것이 좋다.
    - 처음부터 기능 별로 함수를 만드는 것은 어렵다. 일단 전체 동작을 구현해보고 이후로 함수로 나누는 연습을 하자.

```java
package 프로그래머스.배열.방문길이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Sol {
    // 좌표가 범위를 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        // 배열을 사용하기 위해서 -5 ~ 5까지지만 -> 0 ~ 10까지로 표현한다.
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    // 이동 좌표를 결정하는 해시맵
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }

    // 아니 근데 나도 이렇게 햇는데..? 무슨 차이일까 ㅠ?
    public static int solution(String dirs) {
        initLocation();
        int x = 5, y = 5; // 5,5는 0,0을 의미한다. 배열 idx로 음수를 쓸 수 없기 때문
        Set<String> answer = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            // 이런 더하고 빼는 값들을 offset이라고 한다.
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            // 좌표를 벗어나지않은 경우에만 처리
            if (isValidMove(nx, ny)) {
                // 좌표는 A->B나 B<-A나 같아야하기때문에 한번에 두개씩 추가한다.
                answer.add(x + "" + y + "" + nx + "" + ny);
                answer.add(nx + "" + ny + "" + x + "" + y);

                // 좌표를 이동했기때문에 좌표 이동
                x = nx;
                y = ny;
            }
        }
        return answer.size() / 2;
    }

    public static void main(String[] args) {
//        System.out.println(T.solution("ULURRDLLU"));
//        System.out.println(T.solution("LULLLLLLU"));
        System.out.println(solution("UDLRDURL")); // 4
    }
}

```
### 내가 틀린 이유
문자열을 추가하는 방법이 틀렸던 것 같다!
- 저장하던 값이 음수라서!
> 나는 음수로 사용해서! 좌표를 뒤집어 저장하게되는 쪽에서 문제가 발생했던 것 같다!
> 문자열로 저장하는데, `0-10-1`을 뒤집으면 `1-01-0`이 되니까..!

### 배운 점
> `음수`를 `키값`으로 사용하는 걸 자제하는 것이 에러 가능성을 내려준다는 걸 배운 것 같다.